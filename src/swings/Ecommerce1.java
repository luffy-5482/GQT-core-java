package swings;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Author: [tayyab sirkazi]
 * Date: [18.08.2025]
 *
 * Project Name: E-commerce Application (Modernized UI)
 * Technologies Used:
 * - Java (Core Java)
 * - Java Swing (GUI)
 * - AWT Event Handling (ActionListeners)
 *
 * Notes:
 * - This version upgrades the original combo-box driven UI to a more website-like layout:
 *   Header with search, left sidebar category tree, product grid in center, and cart on the right.
 */
public class Ecommerce1 extends JFrame {

    // ---------------------------- Data Models ----------------------------

    // Represents a product with details like name, brand, price, etc.
    static class Product {
        String name, brand, description;
        double price, rating;
        int quantity = 1;

        Product(String name, String brand, double price, double rating, String desc) {
            this.name = name;
            this.brand = brand;
            this.price = price;
            this.rating = rating;
            this.description = desc;
        }

        public String toString() {
            return name + " (" + brand + ")";
        }

        public String toCartString() {
            return quantity + "× " + name + " – ₹" + String.format("%.2f", price * quantity);
        }
    }

    // Represents a subcategory containing products
    static class SubCategory {
        String name;
        List<Product> prods;
        public SubCategory(String name, List<Product> prods) {
            this.name = name;
            this.prods = prods;
        }
        public String toString() { return name; }
    }

    // Represents a category containing subcategories
    static class Category {
        String name;
        List<SubCategory> subs;
        Category(String nm, List<SubCategory> subs) {
            name = nm;
            this.subs = subs;
        }
        public String toString() { return name; }
    }

    // ---------------------------- Fields ----------------------------

    // Catalog + Cart
    private final List<Category> catalog = new ArrayList<>();
    private final java.util.List<Product> cart = new ArrayList<>();

    // UI
    private JTextField tfSearch;
    private JLabel lblCartCount;
    private JLabel lblTotal;
    private JTextArea taCart;
    private JPanel productGrid; // center grid to show product cards
    private JTree categoryTree; // left sidebar

    // ---------------------------- Constructor ----------------------------

    public Ecommerce1() {
        setTitle("E‑Kart Classic");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);

        buildCatalog();
        buildUI();
        loadAllProducts(); // initial view
        refreshCart();

        setVisible(true);
    }

    // ---------------------------- Catalog Setup ----------------------------

    private void buildCatalog() {
        catalog.clear();

        // ---------------- Home Decor ----------------
        catalog.add(new Category("Home Decor", Arrays.asList(
            new SubCategory("Kitchen Appliances", Arrays.asList(
                new Product("Philips Toaster", "Philips", 2499, 4.5, "2‑slice toaster with adjustable browning and auto pop‑up for perfect toast."),
                new Product("Prestige Mixer", "Prestige", 3499, 4.2, "750W powerful mixer with 3 stainless steel jars and overload protection."),
                new Product("Bajaj Coffee Maker", "Bajaj", 1999, 4.0, "600W drip coffee maker with glass carafe and anti‑drip function."),
                new Product("Morphy Richards Kettle", "Morphy Richards", 1799, 4.3, "1.7L cordless electric kettle with auto shut‑off and rapid boil."),
                new Product("Usha Juice Maker", "Usha", 1299, 4.1, "500W juicer with safety lock and easy‑clean detachable parts.")
            )),
            new SubCategory("Living Area Decor", Arrays.asList(
                new Product("Wall Clock", "Ajanta", 799, 4.4, "Silent sweep quartz wall clock with clear numerals and sturdy frame."),
                new Product("Table Lamp", "Havells", 1299, 4.2, "LED table lamp with 3‑level dimmer, flexible neck and soft eye‑care light."),
                new Product("Floor Rug", "Story@Home", 2999, 4.6, "5×7 ft decorative rug with anti‑skid backing and dense weave."),
                new Product("Photo Frame Set", "Artzolo", 499, 4.1, "Set of 4 MDF frames with wall mounting kit, perfect for collages."),
                new Product("Scented Candle", "Aroma", 399, 4.0, "Set of 3 aromatic candles with long burn time and soothing fragrances.")
            )),
            new SubCategory("Bedroom Accessories", Arrays.asList(
                new Product("Bedside Lamp", "Panasonic", 1499, 4.3, "Soft warm bedside lamp with touch dimming and energy‑efficient LED."),
                new Product("Cotton Bedsheet", "D'Decor", 2499, 4.5, "Queen size 100% cotton bedsheet set with two pillow covers."),
                new Product("Memory Foam Pillow", "Sleepwell", 1999, 4.4, "Orthopedic memory foam pillow that adapts to neck and head shape."),
                new Product("Wall Art Canvas", "PrintGallery", 3499, 4.2, "3‑panel abstract wall art on premium canvas with fade‑resistant inks."),
                new Product("Blackout Curtain", "HomeCentre", 2799, 4.1, "2‑panel blackout curtain blocking light and reducing outside noise.")
            ))
        )));

        // ---------------- Fashion ----------------
        catalog.add(new Category("Fashion", Arrays.asList(
            new SubCategory("Men's Wear", Arrays.asList(
                new Product("Casual Shirt", "Peter England", 1299, 4.3, "Cotton slim‑fit full sleeve shirt with breathable fabric for daily wear."),
                new Product("Jeans", "Levi's", 2499, 4.5, "Stretchable slim‑fit denim in classic blue, durable for everyday use."),
                new Product("Sneakers", "Nike", 3499, 4.6, "Lightweight sneakers with cushioned sole for comfort and style.")
            )),
            new SubCategory("Women's Wear", Arrays.asList(
                new Product("Kurti", "Biba", 1599, 4.4, "Printed cotton kurti with side slits—elegant for casual and festive wear."),
                new Product("Handbag", "Caprese", 2299, 4.2, "Premium handbag with adjustable strap and multiple compartments."),
                new Product("Heels", "Catwalk", 1999, 4.3, "Stylish block heel sandals with cushioned footbed for long wear.")
            )),
            new SubCategory("Accessories", Arrays.asList(
                new Product("Wrist Watch", "Fossil", 5999, 4.7, "Chronograph analog watch with stainless steel strap and 5ATM resistance."),
                new Product("Sunglasses", "Ray‑Ban", 3499, 4.6, "UV‑protected aviators with scratch‑resistant lenses and metal frame.")
            ))
        )));

        // ---------------- Electronics ----------------
        catalog.add(new Category("Electronics", Arrays.asList(
            new SubCategory("Mobiles", Arrays.asList(
                new Product("iPhone 14", "Apple", 79999, 4.8, "6.1‑inch Super Retina XDR, A15 Bionic, dual 12MP cameras, iOS ecosystem."),
                new Product("Galaxy S23", "Samsung", 69999, 4.7, "Dynamic AMOLED, Snapdragon, 256GB storage, pro‑grade camera system."),
                new Product("Redmi Note 12", "Xiaomi", 17999, 4.5, "Affordable 5G with 120Hz AMOLED, 48MP triple camera, 5000mAh battery.")
            )),
            new SubCategory("Laptops", Arrays.asList(
                new Product("MacBook Air M2", "Apple", 104999, 4.8, "13.6‑inch Liquid Retina, Apple M2 chip, 18‑hour battery, lightweight."),
                new Product("Inspiron 15", "Dell", 59999, 4.4, "15.6‑inch FHD, Intel i5 12th Gen, 8GB RAM, 512GB SSD, Windows 11."),
                new Product("Pavilion 14", "HP", 54999, 4.3, "Ryzen 5, 8GB RAM, 512GB SSD, sleek design with backlit keyboard.")
            )),
            new SubCategory("Audio Devices", Arrays.asList(
                new Product("AirPods Pro", "Apple", 24999, 4.7, "ANC, Transparency Mode, spatial audio, wireless charging case."),
                new Product("Airdopes 141", "boAt", 1999, 4.4, "TWS earbuds with fast charging, low latency mode and deep bass."),
                new Product("WH‑XB910N", "Sony", 7999, 4.6, "Over‑ear noise‑cancelling headphones with long 30‑hour battery.")
            ))
        )));

        // ---------------- Groceries ----------------
        catalog.add(new Category("Groceries", Arrays.asList(
            new SubCategory("Fruits", Arrays.asList(
                new Product("Apple (1kg)", "FreshFarm", 199, 4.5, "Fresh Kashmiri apples—crisp, juicy and naturally sweet."),
                new Product("Banana (1 dozen)", "Organic", 79, 4.2, "Naturally ripened bananas rich in potassium and fiber."),
                new Product("Grapes (500g)", "FreshFarm", 129, 4.3, "Seedless green grapes—washed and ready to eat.")
            )),
            new SubCategory("Snacks", Arrays.asList(
                new Product("Potato Chips", "Lay's", 20, 4.2, "Classic salted potato chips, perfect for quick munching."),
                new Product("Chocolate Bar", "Dairy Milk", 50, 4.6, "Smooth and creamy milk chocolate for a sweet treat."),
                new Product("Biscuits", "Parle‑G", 10, 4.1, "Original glucose biscuits—light, tasty and nostalgic.")
            )),
            new SubCategory("Beverages", Arrays.asList(
                new Product("Cola (2L)", "Coca‑Cola", 110, 4.3, "2‑liter family pack—serve chilled."),
                new Product("Orange Juice (1L)", "Tropicana", 120, 4.5, "100% real fruit juice with no added preservatives."),
                new Product("Green Tea (100 bags)", "Lipton", 299, 4.4, "Refreshing green tea—rich in antioxidants.")
            ))
        )));

        // ---------------- Sports & Fitness ----------------
        catalog.add(new Category("Sports & Fitness", Arrays.asList(
            new SubCategory("Gym Equipment", Arrays.asList(
                new Product("Dumbbell Set", "FitPro", 2999, 4.5, "10kg adjustable dumbbell set with secure grips."),
                new Product("Yoga Mat", "Reebok", 1499, 4.4, "Anti‑slip yoga mat with optimal cushioning for joints."),
                new Product("Treadmill", "PowerMax", 34999, 4.6, "Motorized treadmill with LCD and preset workout programs.")
            )),
            new SubCategory("Outdoor Sports", Arrays.asList(
                new Product("Cricket Bat", "SS", 1999, 4.5, "English willow bat—balanced pick‑up and sturdy handle."),
                new Product("Football", "Nivia", 899, 4.3, "Size‑5 football with durable outer cover for regular play."),
                new Product("Badminton Racket", "Yonex", 1299, 4.4, "Lightweight graphite racket for quicker swings.")
            )),
            new SubCategory("Footwear", Arrays.asList(
                new Product("Running Shoes", "Adidas", 3499, 4.5, "Breathable mesh upper with responsive cushioning."),
                new Product("Studs", "Puma", 2499, 4.4, "Football studs with firm ground traction."),
                new Product("Sports Sandals", "Sparx", 1499, 4.3, "Outdoor sandals with adjustable straps and EVA sole.")
            ))
        )));
    }

    // ---------------------------- UI Construction ----------------------------

    private void buildUI() {
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(246, 248, 250));

        // Header bar
        JPanel header = new JPanel(new BorderLayout(10, 10));
        header.setBorder(new EmptyBorder(12, 16, 12, 16));
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("E‑Kart");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JPanel searchArea = new JPanel(new BorderLayout(6, 6));
        tfSearch = new JTextField();
        tfSearch.setToolTipText("Search products...");
        JButton btnSearch = new JButton("Search");
        stylePrimary(btnSearch);
        searchArea.add(tfSearch, BorderLayout.CENTER);
        searchArea.add(btnSearch, BorderLayout.EAST);
        searchArea.setOpaque(false);

        JPanel cartArea = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        lblCartCount = new JLabel("Cart: 0 items");
        lblCartCount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cartArea.setOpaque(false);
        cartArea.add(lblCartCount);

        header.add(title, BorderLayout.WEST);
        header.add(searchArea, BorderLayout.CENTER);
        header.add(cartArea, BorderLayout.EAST);

        // Left: Category Tree
        categoryTree = buildCategoryTree();
        JScrollPane leftScroll = new JScrollPane(categoryTree);
        leftScroll.setPreferredSize(new Dimension(220, 0));
        TitledBorder leftBorder = BorderFactory.createTitledBorder("Categories");
        leftBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 14));
        leftScroll.setBorder(new CompoundBorder(new EmptyBorder(6, 10, 6, 6), leftBorder));

        // Center: Product Grid
        productGrid = new JPanel(new GridLayout(0, 2, 12, 12));
        productGrid.setBorder(new EmptyBorder(12, 6, 12, 6));
        productGrid.setBackground(new Color(246, 248, 250));
        JScrollPane centerScroll = new JScrollPane(productGrid);
        centerScroll.getVerticalScrollBar().setUnitIncrement(16);
        centerScroll.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Right: Cart panel
        JPanel cartPanel = new JPanel(new BorderLayout(8, 8));
        cartPanel.setPreferredSize(new Dimension(320, 0));
        cartPanel.setBackground(Color.WHITE);
        cartPanel.setBorder(new CompoundBorder(new EmptyBorder(6, 6, 6, 10),
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(225, 230, 235)), "Your Cart")));

        taCart = new JTextArea(14, 24);
        taCart.setEditable(false);
        taCart.setFont(new Font("Monospaced", Font.PLAIN, 13));
        taCart.setBackground(new Color(245, 255, 248));
        JScrollPane cartScroll = new JScrollPane(taCart);

        JPanel cartBottom = new JPanel(new GridBagLayout());
        cartBottom.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;

        lblTotal = new JLabel("Total: ₹0.00");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotal.setForeground(new Color(0, 128, 0));

        JButton btnRemove = new JButton("Remove Last");
        styleWarning(btnRemove);
        JButton btnClear = new JButton("Clear Cart");
        styleDanger(btnClear);
        JButton btnCheckout = new JButton("Checkout");
        stylePrimary(btnCheckout);

        cartBottom.add(lblTotal, gbc);
        gbc.gridy++;
        cartBottom.add(btnRemove, gbc);
        gbc.gridy++;
        cartBottom.add(btnClear, gbc);
        gbc.gridy++;
        cartBottom.add(btnCheckout, gbc);

        cartPanel.add(cartScroll, BorderLayout.CENTER);
        cartPanel.add(cartBottom, BorderLayout.SOUTH);

        // Layout add
        add(header, BorderLayout.NORTH);
        add(leftScroll, BorderLayout.WEST);
        add(centerScroll, BorderLayout.CENTER);
        add(cartPanel, BorderLayout.EAST);

        // ---------------- Events ----------------

        // Search
        btnSearch.addActionListener(e -> applySearch());
        tfSearch.addActionListener(e -> applySearch());

        // Category tree selection -> load products of subcategory or category
        categoryTree.addTreeSelectionListener(ev -> {
            TreePath path = categoryTree.getSelectionPath();
            if (path == null) return;
            Object nodeObj = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
            if (nodeObj instanceof SubCategory) {
                loadProducts(((SubCategory) nodeObj).prods);
            } else if (nodeObj instanceof Category) {
                // If category selected, aggregate and show all its products
                List<Product> list = new ArrayList<>();
                for (SubCategory s : ((Category) nodeObj).subs) list.addAll(s.prods);
                loadProducts(list);
            }
        });

        // Cart buttons
        btnRemove.addActionListener(e -> {
            if (!cart.isEmpty()) {
                cart.remove(cart.size() - 1);
                refreshCart();
            }
        });

        btnClear.addActionListener(e -> {
            cart.clear();
            refreshCart();
        });

        btnCheckout.addActionListener(e -> checkoutBill());
    }

    private void applySearch() {
        String q = tfSearch.getText().trim().toLowerCase();
        if (q.isEmpty()) {
            loadAllProducts();
            return;
        }
        List<Product> all = new ArrayList<>();
        for (Category c : catalog) for (SubCategory s : c.subs) all.addAll(s.prods);
        List<Product> filtered = new ArrayList<>();
        for (Product p : all) {
            if (p.name.toLowerCase().contains(q) || p.brand.toLowerCase().contains(q) || p.description.toLowerCase().contains(q))
                filtered.add(p);
        }
        loadProducts(filtered);
    }

    // ---------------------------- Tree Builder ----------------------------

    private JTree buildCategoryTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("All Categories");
        for (Category c : catalog) {
            DefaultMutableTreeNode cNode = new DefaultMutableTreeNode(c);
            for (SubCategory s : c.subs) {
                DefaultMutableTreeNode sNode = new DefaultMutableTreeNode(s);
                cNode.add(sNode);
            }
            root.add(cNode);
        }
        JTree tree = new JTree(root);
        tree.setRootVisible(true);
        tree.setShowsRootHandles(true);
        tree.setBackground(new Color(250, 251, 252));
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            private final Color sel = new Color(230, 240, 255);
            private final Color norm = new Color(250, 251, 252);
            @Override public Component getTreeCellRendererComponent(JTree tr, Object value, boolean selc, boolean exp, boolean leaf, int row, boolean hasFocus) {
                Component c = super.getTreeCellRendererComponent(tr, value, selc, exp, leaf, row, hasFocus);
                setBorder(new EmptyBorder(4, 6, 4, 6));
                if (selc) setBackgroundSelectionColor(sel); else setBackgroundNonSelectionColor(norm);
                setFont(new Font("Segoe UI", Font.PLAIN, 13));
                return c;
            }
        });
        for (int i = 0; i < tree.getRowCount(); i++) tree.expandRow(i);
        return tree;
    }

    // ---------------------------- Product Grid ----------------------------

    private void loadAllProducts() {
        List<Product> all = new ArrayList<>();
        for (Category c : catalog) for (SubCategory s : c.subs) all.addAll(s.prods);
        loadProducts(all);
    }

    private void loadProducts(List<Product> prods) {
        productGrid.removeAll();
        if (prods == null || prods.isEmpty()) {
            JLabel empty = new JLabel("No products found.", SwingConstants.CENTER);
            empty.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            JPanel wrap = new JPanel(new BorderLayout());
            wrap.setOpaque(false);
            wrap.add(empty, BorderLayout.CENTER);
            productGrid.add(wrap);
        } else {
            for (Product p : prods) productGrid.add(new ProductCard(p));
        }
        productGrid.revalidate();
        productGrid.repaint();
    }

    private class ProductCard extends JPanel {
        Product p;
        JSpinner qty;
        ProductCard(Product p) {
            this.p = p;
            setLayout(new BorderLayout(8, 8));
            setBackground(Color.WHITE);
            setBorder(new CompoundBorder(new LineBorder(new Color(230, 235, 240), 1, true), new EmptyBorder(10, 12, 12, 12)));

            // Title area
            JLabel lblName = new JLabel(p.name);
            lblName.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblBrand = new JLabel("Brand: " + p.brand);
            JLabel lblRating = new JLabel("Rating: " + p.rating + " " + stars(p.rating));
            JLabel lblPrice = new JLabel("₹" + String.format("%.2f", p.price));
            lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblPrice.setForeground(new Color(0, 128, 0));

            JTextArea desc = new JTextArea(p.description);
            desc.setEditable(false);
            desc.setLineWrap(true);
            desc.setWrapStyleWord(true);
            desc.setBackground(new Color(250, 253, 250));
            desc.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            top.add(lblName, BorderLayout.NORTH);

            JPanel info = new JPanel(new GridLayout(3, 1));
            info.setOpaque(false);
            info.add(lblBrand);
            info.add(lblRating);
            info.add(lblPrice);

            top.add(info, BorderLayout.CENTER);

            // Bottom controls
            JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
            bottom.setOpaque(false);
            qty = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
            JButton btnAdd = new JButton("Add to Cart");
            styleSuccess(btnAdd);
            btnAdd.addActionListener(e -> addToCart(p, (int) qty.getValue()));
            bottom.add(new JLabel("Qty:"));
            bottom.add(qty);
            bottom.add(btnAdd);

            add(top, BorderLayout.NORTH);
            add(new JScrollPane(desc), BorderLayout.CENTER);
            add(bottom, BorderLayout.SOUTH);
        }
    }

    private String stars(double rating) {
        int full = (int) Math.round(rating); // simple approximation 0..5
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i < full ? '★' : '☆');
        return sb.toString();
    }

    // ---------------------------- Cart Logic ----------------------------

    private void addToCart(Product p, int q) {
        boolean found = false;
        for (Product cp : cart) {
            if (cp.name.equals(p.name) && cp.brand.equals(p.brand)) {
                cp.quantity += q;
                found = true;
                break;
            }
        }
        if (!found) {
            Product np = new Product(p.name, p.brand, p.price, p.rating, p.description);
            np.quantity = q;
            cart.add(np);
        }
        refreshCart();
    }

    private void refreshCart() {
        taCart.setText("");
        double tot = 0; int idx = 1; int itemCount = 0;
        for (Product p : cart) {
            double sub = p.price * p.quantity;
            taCart.append(String.format("%2d. %-22s ×%d  ₹%.2f\n", idx++, p.name, p.quantity, sub));
            tot += sub; itemCount += p.quantity;
        }
        lblTotal.setText("Total: ₹" + String.format("%.2f", tot));
        lblCartCount.setText("Cart: " + itemCount + (itemCount == 1 ? " item" : " items"));
    }

    private void checkoutBill() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty.");
            return;
        }
        StringBuilder bill = new StringBuilder("FINAL BILL\n---------------------------\n");
        double tot = 0; int idx = 1;
        for (Product p : cart) {
            double sub = p.price * p.quantity;
            bill.append(String.format("%d. %-20s %2d × ₹%.2f = ₹%.2f\n", idx++, p.name, p.quantity, p.price, sub));
            tot += sub;
        }
        bill.append("---------------------------\nTOTAL = ₹" + String.format("%.2f", tot));

        JTextArea ba = new JTextArea(bill.toString());
        ba.setFont(new Font("Monospaced", Font.PLAIN, 12));
        ba.setEditable(false);

        JOptionPane.showMessageDialog(this, new JScrollPane(ba), "Invoice", JOptionPane.PLAIN_MESSAGE);
    }

    // ---------------------------- Button Styles ----------------------------

    private void stylePrimary(AbstractButton b) { styleBtn(b, new Color(10, 132, 255)); }
    private void styleSuccess(AbstractButton b) { styleBtn(b, new Color(48, 209, 88)); }
    private void styleWarning(AbstractButton b) { styleBtn(b, new Color(255, 159, 10)); }
    private void styleDanger(AbstractButton b) { styleBtn(b, new Color(255, 69, 58)); }

    private void styleBtn(AbstractButton b, Color base) {
        b.setFocusPainted(false);
        b.setForeground(Color.WHITE);
        b.setBackground(base);
        b.setBorder(new EmptyBorder(8, 14, 8, 14));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { b.setBackground(base.darker()); }
            @Override public void mouseExited(MouseEvent e) { b.setBackground(base); }
        });
    }

    // ---------------------------- Main ----------------------------

    public static void main(String[] args) {
        // Make all Swing texts black
        UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("TextArea.foreground", Color.BLACK);
        UIManager.put("Tree.textForeground", Color.BLACK);
        UIManager.put("Table.foreground", Color.BLACK);

        SwingUtilities.invokeLater(() -> new Ecommerce1().setVisible(true));
    }

}
