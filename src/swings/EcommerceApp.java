// EcommerceApp.java
// Single-file Java Swing E‑Commerce demo app with categories, subcategories, products, cart, and pricing.
// How to run:
//   javac EcommerceApp.java
//   java EcommerceApp
// Tested with Java 8+.
package swings;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class EcommerceApp extends JFrame {
    // Data models
    static class Product {
        final String id;
        final String name;
        final String category;       // top-level
        final String subcategory;    // second-level
        final double price;

        Product(String id, String name, String category, String subcategory, double price) {
            this.id = id; this.name = name; this.category = category; this.subcategory = subcategory; this.price = price;
        }
    }

    static class CartItem {
        final Product product;
        int quantity;
        CartItem(Product p, int q) { this.product = p; this.quantity = q; }
        double lineTotal() { return product.price * quantity; }
    }

    static class Cart {
        final Map<String, CartItem> items = new LinkedHashMap<>();
        void add(Product p, int qty) {
            if (qty <= 0) return;
            items.compute(p.id, (k, v) -> {
                if (v == null) return new CartItem(p, qty);
                v.quantity += qty; return v;
            });
        }
        void setQty(String productId, int qty) {
            CartItem ci = items.get(productId);
            if (ci == null) return;
            if (qty <= 0) items.remove(productId); else ci.quantity = qty;
        }
        void remove(String productId) { items.remove(productId); }
        void clear() { items.clear(); }
        double total() {
            double t = 0;
            for (CartItem ci : items.values()) t += ci.lineTotal();
            return t;
        }
        int itemCount() {
            int c = 0; for (CartItem ci : items.values()) c += ci.quantity; return c;
        }
        List<CartItem> asList() { return new ArrayList<>(items.values()); }
    }

    // UI components
    private final JTree categoryTree;
    private final JTable productTable;
    private final JTable cartTable;
    private final JLabel totalLabel;
    private final JSpinner qtySpinner;
    private final JTextField searchField;

    private final DefaultTableModel productModel;
    private final DefaultTableModel cartModel;

    private final Cart cart = new Cart();

    // Data store
    private final List<Product> allProducts = new ArrayList<>();

    private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);

    public EcommerceApp() {
        super("Swing E‑Commerce Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menu bar
        setJMenuBar(buildMenuBar());

        // Left: Category tree
        DefaultMutableTreeNode root = buildCategoryTree();
        categoryTree = new JTree(root);
        categoryTree.setRootVisible(true);
        categoryTree.setShowsRootHandles(true);
        categoryTree.addTreeSelectionListener(new CategorySelectionHandler());
        JScrollPane leftScroll = new JScrollPane(categoryTree);
        leftScroll.setPreferredSize(new Dimension(260, 600));

        // Top toolbar (search + qty + add to cart)
        JToolBar topBar = new JToolBar();
        topBar.setFloatable(false);
        topBar.setBorder(new EmptyBorder(6, 8, 6, 8));
        topBar.add(new JLabel("Search: "));
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(260, 28));
        topBar.add(searchField);
        JButton searchBtn = new JButton("Go");
        topBar.add(Box.createHorizontalStrut(10));
        topBar.add(searchBtn);
        topBar.add(Box.createHorizontalStrut(20));
        topBar.add(new JLabel("Qty:"));
        qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        qtySpinner.setMaximumSize(new Dimension(60, 28));
        topBar.add(qtySpinner);
        JButton addToCartBtn = new JButton("Add Selected to Cart");
        topBar.add(Box.createHorizontalStrut(10));
        topBar.add(addToCartBtn);

        // Center-right: Products table
        productModel = new DefaultTableModel(new Object[]{"ID", "Product", "Category", "Subcategory", "Price"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        productTable = new JTable(productModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setAutoCreateRowSorter(true);
        JScrollPane productScroll = new JScrollPane(productTable);

        // Bottom-right: Cart panel
        cartModel = new DefaultTableModel(new Object[]{"Product", "Price", "Qty", "Line Total", "ID"}, 0) {
            public boolean isCellEditable(int r, int c) {
                return c == 2; // only Qty editable
            }
        };
        cartTable = new JTable(cartModel);
        cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cartTable.getColumnModel().getColumn(4).setMinWidth(0);
        cartTable.getColumnModel().getColumn(4).setMaxWidth(0);
        cartTable.getColumnModel().getColumn(4).setWidth(0); // hide ID

        // Make Qty column a spinner editor
        cartTable.getColumnModel().getColumn(2).setCellEditor(new SpinnerEditor(1, 0, 99, 1));

        JScrollPane cartScroll = new JScrollPane(cartTable);
        JPanel cartActions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton removeBtn = new JButton("Remove Selected");
        JButton clearBtn = new JButton("Clear Cart");
        JButton checkoutBtn = new JButton("Checkout");
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(totalLabel.getFont().deriveFont(Font.BOLD, 16f));
        cartActions.add(totalLabel);
        cartActions.add(removeBtn);
        cartActions.add(clearBtn);
        cartActions.add(checkoutBtn);

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(new JLabel("  Cart"), BorderLayout.NORTH);
        cartPanel.add(cartScroll, BorderLayout.CENTER);
        cartPanel.add(cartActions, BorderLayout.SOUTH);
        cartPanel.setPreferredSize(new Dimension(600, 260));

        // Right side split: products above, cart below
        JSplitPane rightSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, productScroll, cartPanel);
        rightSplit.setResizeWeight(0.65);

        // Main split: categories left, right content
        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScroll, rightSplit);
        mainSplit.setResizeWeight(0.22);

        add(topBar, BorderLayout.NORTH);
        add(mainSplit, BorderLayout.CENTER);

        // Populate data
        seedData();
        refreshProductTable(null, null, null); // show all

        // Listeners
        searchBtn.addActionListener(e -> doSearch());
        addToCartBtn.addActionListener(e -> addSelectedProductToCart());
        removeBtn.addActionListener(e -> removeSelectedCartItem());
        clearBtn.addActionListener(e -> { cart.clear(); refreshCartTable(); });
        checkoutBtn.addActionListener(e -> onCheckout());

        // Update cart when quantity edited
        cartModel.addTableModelListener(e -> {
            if (e.getColumn() == 2 || e.getColumn() == -1) { // qty or structure change
                // Sync quantities back to cart
                for (int i = 0; i < cartModel.getRowCount(); i++) {
                    String id = (String) cartModel.getValueAt(i, 4);
                    Object qtyObj = cartModel.getValueAt(i, 2);
                    int q = 1;
                    try { q = Integer.parseInt(qtyObj.toString()); } catch (Exception ex) { q = 1; }
                    cart.setQty(id, q);
                }
                updateTotal();
            }
        });
    }

    private JMenuBar buildMenuBar() {
        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> dispose());
        file.add(exit);

        JMenu view = new JMenu("View");
        JMenuItem all = new JMenuItem("Show All Products");
        all.addActionListener(e -> refreshProductTable(null, null, searchField.getText().trim()));
        view.add(all);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Swing E‑Commerce Demo\nCategories → Subcategories → Products\nAdd to cart, edit quantities, checkout.",
                "About", JOptionPane.INFORMATION_MESSAGE));
        help.add(about);

        mb.add(file); mb.add(view); mb.add(help);
        return mb;
    }

    private DefaultMutableTreeNode buildCategoryTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("All Categories");

        DefaultMutableTreeNode electronics = new DefaultMutableTreeNode("Electronics");
        electronics.add(new DefaultMutableTreeNode("Mobiles"));
        electronics.add(new DefaultMutableTreeNode("Laptops"));
        electronics.add(new DefaultMutableTreeNode("Audio"));
        electronics.add(new DefaultMutableTreeNode("Accessories"));

        DefaultMutableTreeNode groceries = new DefaultMutableTreeNode("Groceries");
        groceries.add(new DefaultMutableTreeNode("Fruits"));
        groceries.add(new DefaultMutableTreeNode("Vegetables"));
        groceries.add(new DefaultMutableTreeNode("Beverages"));
        groceries.add(new DefaultMutableTreeNode("Snacks"));

        DefaultMutableTreeNode fashion = new DefaultMutableTreeNode("Fashion");
        fashion.add(new DefaultMutableTreeNode("Men"));
        fashion.add(new DefaultMutableTreeNode("Women"));
        fashion.add(new DefaultMutableTreeNode("Kids"));

        DefaultMutableTreeNode home = new DefaultMutableTreeNode("Home & Kitchen");
        home.add(new DefaultMutableTreeNode("Appliances"));
        home.add(new DefaultMutableTreeNode("Cookware"));
        home.add(new DefaultMutableTreeNode("Decor"));

        DefaultMutableTreeNode books = new DefaultMutableTreeNode("Books");
        books.add(new DefaultMutableTreeNode("Fiction"));
        books.add(new DefaultMutableTreeNode("Non-Fiction"));
        books.add(new DefaultMutableTreeNode("Academic"));

        root.add(electronics);
        root.add(groceries);
        root.add(fashion);
        root.add(home);
        root.add(books);
        return root;
    }

    private void seedData() {
        // Electronics
        allProducts.add(new Product("E001", "iPhone 15", "Electronics", "Mobiles", 899.00));
        allProducts.add(new Product("E002", "Samsung Galaxy S24", "Electronics", "Mobiles", 799.00));
        allProducts.add(new Product("E003", "MacBook Air M2", "Electronics", "Laptops", 1099.00));
        allProducts.add(new Product("E004", "Dell XPS 13", "Electronics", "Laptops", 1199.00));
        allProducts.add(new Product("E005", "Sony WH-1000XM5", "Electronics", "Audio", 349.99));
        allProducts.add(new Product("E006", "Anker USB‑C Cable", "Electronics", "Accessories", 12.99));

        // Groceries
        allProducts.add(new Product("G001", "Bananas (1kg)", "Groceries", "Fruits", 2.49));
        allProducts.add(new Product("G002", "Apples (1kg)", "Groceries", "Fruits", 3.19));
        allProducts.add(new Product("G003", "Tomatoes (1kg)", "Groceries", "Vegetables", 2.10));
        allProducts.add(new Product("G004", "Coca‑Cola (2L)", "Groceries", "Beverages", 1.99));
        allProducts.add(new Product("G005", "Potato Chips (200g)", "Groceries", "Snacks", 1.49));

        // Fashion
        allProducts.add(new Product("F001", "Men's T‑Shirt", "Fashion", "Men", 12.00));
        allProducts.add(new Product("F002", "Women's Jeans", "Fashion", "Women", 35.00));
        allProducts.add(new Product("F003", "Kids Sneakers", "Fashion", "Kids", 22.50));

        // Home & Kitchen
        allProducts.add(new Product("H001", "Air Fryer", "Home & Kitchen", "Appliances", 89.00));
        allProducts.add(new Product("H002", "Non‑stick Pan", "Home & Kitchen", "Cookware", 24.99));
        allProducts.add(new Product("H003", "Wall Clock", "Home & Kitchen", "Decor", 18.75));

        // Books
        allProducts.add(new Product("B001", "Fantasy Novel", "Books", "Fiction", 9.99));
        allProducts.add(new Product("B002", "Self‑Help Guide", "Books", "Non-Fiction", 12.49));
        allProducts.add(new Product("B003", "Data Structures Textbook", "Books", "Academic", 39.95));
    }

    private void refreshProductTable(String category, String subcategory, String search) {
        String searchLower = search == null ? null : search.toLowerCase(Locale.ROOT).trim();
        productModel.setRowCount(0);
        for (Product p : allProducts) {
            boolean ok = true;
            if (category != null && !category.equals(p.category)) ok = false;
            if (subcategory != null && !subcategory.equals(p.subcategory)) ok = false;
            if (searchLower != null && !searchLower.isEmpty()) {
                String hay = (p.name + " " + p.category + " " + p.subcategory + " " + p.id).toLowerCase(Locale.ROOT);
                if (!hay.contains(searchLower)) ok = false;
            }
            if (ok) {
                productModel.addRow(new Object[]{p.id, p.name, p.category, p.subcategory, CURRENCY.format(p.price)});
            }
        }
        if (productModel.getRowCount() == 0) {
            productModel.addRow(new Object[]{"-", "No products found", category == null ? "-" : category, subcategory == null ? "-" : subcategory, "-"});
        }
    }

    private void addSelectedProductToCart() {
        int r = productTable.getSelectedRow();
        if (r < 0) {
            JOptionPane.showMessageDialog(this, "Select a product to add.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int modelRow = productTable.convertRowIndexToModel(r);
        String id = String.valueOf(productModel.getValueAt(modelRow, 0));
        if ("-".equals(id)) return;
        Product p = findProductById(id);
        if (p == null) return;
        int qty = (Integer) qtySpinner.getValue();
        cart.add(p, qty);
        refreshCartTable();
        JOptionPane.showMessageDialog(this, p.name + " added to cart (x" + qty + ")");
    }

    private void refreshCartTable() {
        cartModel.setRowCount(0);
        for (CartItem ci : cart.asList()) {
            cartModel.addRow(new Object[]{
                    ci.product.name,
                    CURRENCY.format(ci.product.price),
                    ci.quantity,
                    CURRENCY.format(ci.lineTotal()),
                    ci.product.id
            });
        }
        updateTotal();
    }

    private void updateTotal() {
        totalLabel.setText("Total: " + CURRENCY.format(cart.total()));
    }

    private void removeSelectedCartItem() {
        int r = cartTable.getSelectedRow();
        if (r < 0) return;
        String id = (String) cartModel.getValueAt(r, 4);
        cart.remove(id);
        refreshCartTable();
    }

    private void onCheckout() {
        if (cart.items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Items (" + cart.itemCount() + "):\n\n");
        for (CartItem ci : cart.asList()) {
            sb.append(String.format("%s x%d - %s\n", ci.product.name, ci.quantity, CURRENCY.format(ci.lineTotal())));
        }
        sb.append("\nTotal: ").append(CURRENCY.format(cart.total()));
        JOptionPane.showMessageDialog(this, sb.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    private Product findProductById(String id) {
        for (Product p : allProducts) if (p.id.equals(id)) return p; return null;
    }

    private void doSearch() {
        String q = searchField.getText();
        // Keep selected category/subcategory filter from tree
        TreePath tp = categoryTree.getSelectionPath();
        String[] cs = resolveCategorySelection(tp);
        refreshProductTable(cs[0], cs[1], q);
    }

    private class CategorySelectionHandler implements TreeSelectionListener {
        @Override public void valueChanged(TreeSelectionEvent e) {
            TreePath tp = e.getPath();
            String[] cs = resolveCategorySelection(tp);
            searchField.setText("");
            refreshProductTable(cs[0], cs[1], null);
        }
    }

    private String[] resolveCategorySelection(TreePath tp) {
        String category = null, sub = null;
        if (tp != null) {
            Object[] parts = tp.getPath();
            // [root, category] or [root, category, sub]
            if (parts.length >= 2) category = parts[1].toString();
            if (parts.length >= 3) sub = parts[2].toString();
            if ("All Categories".equals(category)) category = null;
        }
        return new String[]{category, sub};
    }

    // Spinner editor for JTable cells
    static class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        final JSpinner spinner;
        SpinnerEditor(int value, int min, int max, int step) {
            spinner = new JSpinner(new SpinnerNumberModel(value, min, max, step));
        }
        @Override public Object getCellEditorValue() { return spinner.getValue(); }
        @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            try {
                int v = Integer.parseInt(String.valueOf(value));
                ((SpinnerNumberModel) spinner.getModel()).setValue(v);
            } catch (Exception ignored) {}
            return spinner;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EcommerceApp().setVisible(true));
    }
}
