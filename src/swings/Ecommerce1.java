package swings;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Author: [Mohammedtayyab Sirkazi]
 * Date: [20.08.2025]
 * 
 * Project Name:E-Kart Application
 * Technologies Used:
 * - Java (Core Java)
 * - Java Swing (Graphical User Interface)
 * - AWT Event Handling (ActionListeners)
 */
public class Ecommerce1 extends JFrame {

    // ---------------------------- Inner Classes ----------------------------

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

        public String toString() {
            return name;
        }
    }

    // Represents a category containing subcategories
    static class Category {
        String name;
        List<SubCategory> subs;

        Category(String nm, List<SubCategory> subs) {
            name = nm;
            this.subs = subs;
        }

        public String toString() {
            return name;
        }
    }

    // ---------------------------- Fields ----------------------------

    // UI Components
    private JComboBox<Category> cbCategory;
    private JComboBox<SubCategory> cbSub;
    private JComboBox<Product> cbProd;
    private JLabel lblBrand, lblRating, lblPrice;
    private JTextArea taDesc;
    private JSpinner spQty;
    private JButton btnAdd, btnRemove, btnClear, btnCheckout;
    private JTextArea taCart;
    private JLabel lblTotal;

    // Cart and catalog data
    private final List<Product> cart = new ArrayList<>();
    private final List<Category> catalog = new ArrayList<>();

    // ---------------------------- Constructor ----------------------------

    public Ecommerce1() {
        setTitle("E-Commerce");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); 

        buildCatalog();   
        buildUI();        
        loadSubs(catalog.get(0));  
        loadProds((SubCategory) cbSub.getItemAt(0)); 
        hookEvents();     
        refreshCart();    
        setVisible(true); 
    }

    // ---------------------------- Data Setup ----------------------------

    // Populate catalog with categories, subcategories, and products
    private void buildCatalog() {
        catalog.add(new Category("Home Decor", Arrays.asList(
            new SubCategory("Kitchen Appliances", Arrays.asList(
                new Product("Philips Toaster", "Philips", 2499, 4.5, "2-slice toaster with adjustable browning."),
                new Product("Prestige Mixer", "Prestige", 3499, 4.2, "750W mixer with 3 jars."),
                new Product("Bajaj Coffee Maker", "Bajaj", 1999, 4.0, "600W coffee maker w/ glass jug."),
                new Product("Morphy Richards Kettle", "Morphy Richards", 1799, 4.3, "1.7 L electric kettle."),
                new Product("Usha Juice Maker", "Usha", 1299, 4.1, "500W juicer w/ safety lock.")
            )),
            new SubCategory("Living Area Decor", Arrays.asList(
                new Product("Wall Clock", "Ajanta", 799, 4.4, "Silent quartz wall clock."),
                new Product("Table Lamp", "Havells", 1299, 4.2, "LED table lamp w/ dimmer."),
                new Product("Floor Rug", "Story@Home", 2999, 4.6, "5×7 ft deco rug."),
                new Product("Photo Frame Set", "Artzolo", 499, 4.1, "Set of 4 MDF frames."),
                new Product("Scented Candle", "Aroma", 399, 4.0, "Set of 3 aromatic candles.")
            )),
            new SubCategory("Bedroom Accessories", Arrays.asList(
                new Product("Bedside Lamp", "Panasonic", 1499, 4.3, "Soft yellow bedside lamp."),
                new Product("Cotton Bedsheet", "D'Decor", 2499, 4.5, "Queen size 100% cotton."),
                new Product("Memory Foam Pillow", "Sleepwell", 1999, 4.4, "Orthopedic memory foam pillow."),
                new Product("Wall Art Canvas", "PrintGallery", 3499, 4.2, "3-panel abstract wall art."),
                new Product("Blackout Curtain", "HomeCentre", 2799, 4.1, "2-panel blackout curtain.")
            ))
        )));
    }


    
    private void buildUI() {
        setLayout(new BorderLayout(8, 8));
        getContentPane().setBackground(new Color(245, 245, 245)); // Light background

        
        cbCategory = new JComboBox<>(catalog.toArray(new Category[0]));
        cbSub = new JComboBox<>();
        cbProd = new JComboBox<>();

        
        lblBrand = new JLabel();
        lblRating = new JLabel();
        lblPrice = new JLabel();

        
        taDesc = new JTextArea(4, 30);
        taDesc.setLineWrap(true);
        taDesc.setWrapStyleWord(true);
        taDesc.setEditable(false);
        taDesc.setBackground(new Color(255, 255, 240));
        JScrollPane descScroll = new JScrollPane(taDesc);

        
        spQty = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        btnAdd = new JButton("Add to Cart");
        btnAdd.setBackground(new Color(102, 205, 170));

        
        JPanel selPanel = new JPanel(new GridBagLayout());
        selPanel.setBorder(new EtchedBorder());
        selPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; selPanel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1; selPanel.add(cbCategory, gbc);
        gbc.gridx = 0; gbc.gridy = 1; selPanel.add(new JLabel("SubCategory:"), gbc);
        gbc.gridx = 1; selPanel.add(cbSub, gbc);
        gbc.gridx = 0; gbc.gridy = 2; selPanel.add(new JLabel("Product:"), gbc);
        gbc.gridx = 1; selPanel.add(cbProd, gbc);
        // Panel to show product info
        JPanel infoPanel = new JPanel(new BorderLayout(5, 5));
        JPanel northInfo = new JPanel(new GridLayout(3, 1, 3, 3));
        northInfo.setBackground(Color.WHITE);
        northInfo.add(lblBrand);
        northInfo.add(lblRating);
        northInfo.add(lblPrice);
        infoPanel.add(northInfo, BorderLayout.NORTH);
        infoPanel.add(descScroll, BorderLayout.CENTER);
        JPanel qtyP = new JPanel();
        qtyP.setBackground(Color.WHITE);
        qtyP.add(new JLabel("Qty:"));
        qtyP.add(spQty);
        qtyP.add(btnAdd);
        infoPanel.add(qtyP, BorderLayout.SOUTH);
        infoPanel.setBorder(new EtchedBorder());
        JPanel top = new JPanel(new FlowLayout());
        top.setBackground(new Color(230, 255, 250));
        top.add(selPanel);
        top.add(infoPanel);
        // Cart area
        taCart = new JTextArea(8, 40);
        taCart.setFont(new Font("Monospaced", Font.PLAIN, 14));
        taCart.setEditable(false);
        taCart.setBackground(new Color(240, 255, 255));
        JScrollPane cartScroll = new JScrollPane(taCart);
        // Cart control buttons
        btnRemove = new JButton("Remove Last");
        btnClear = new JButton("Clear Cart");
        btnCheckout = new JButton("Checkout");
        btnRemove.setBackground(new Color(255, 182, 193));
        btnClear.setBackground(new Color(255, 160, 122));
        btnCheckout.setBackground(new Color(144, 238, 144));
        // Total label
        lblTotal = new JLabel("Total: ₹0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setForeground(new Color(0, 102, 0));
        // Control panel
        JPanel ctrl = new JPanel();
        ctrl.setBackground(new Color(240, 255, 255));
        ctrl.add(btnRemove);
        ctrl.add(btnClear);
        ctrl.add(btnCheckout);
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(240, 255, 255));
        bottom.add(cartScroll, BorderLayout.CENTER);
        JPanel b2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        b2.setBackground(new Color(240, 255, 255));
        b2.add(lblTotal);
        b2.add(ctrl);
        bottom.add(b2, BorderLayout.SOUTH);
        // Add panels to main frame
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);
    }
    // ---------------------------- Event Handlers ----------------------------
    // Attach event listeners to UI components
    private void hookEvents() {
        cbCategory.addActionListener(e -> {
            Category c = (Category) cbCategory.getSelectedItem();
            if (c != null) {
                loadSubs(c);
                SubCategory s = (SubCategory) cbSub.getItemAt(0);
                if (s != null) loadProds(s);
            }
        });
        cbSub.addActionListener(e -> {
            SubCategory s = (SubCategory) cbSub.getSelectedItem();
            if (s != null) loadProds(s);
        });

        cbProd.addActionListener(e -> showProdDetails());

        btnAdd.addActionListener(e -> {
            Product p = (Product) cbProd.getSelectedItem();
            if (p != null) {
                int q = (int) spQty.getValue();
                boolean found = false;

                // If product already in cart, increase quantity
                for (Product cp : cart) {
                    if (cp.name.equals(p.name) && cp.brand.equals(p.brand)) {
                        cp.quantity += q;
                        found = true;
                        break;
                    }
                }

                // Otherwise, add new product
                if (!found) {
                    Product np = new Product(p.name, p.brand, p.price, p.rating, p.description);
                    np.quantity = q;
                    cart.add(np);
                }

                refreshCart();
            }
        });

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

    // ---------------------------- Utility Methods ----------------------------

    // Load subcategories based on selected category
    private void loadSubs(Category c) {
        cbSub.removeAllItems();
        for (SubCategory s : c.subs) cbSub.addItem(s);
    }

    // Load products based on selected subcategory
    private void loadProds(SubCategory s) {
        cbProd.removeAllItems();
        if (s == null) return;
        for (Product p : s.prods) cbProd.addItem(p);
        if (cbProd.getItemCount() > 0) cbProd.setSelectedIndex(0);
        showProdDetails();
    }

    // Display selected product details
    private void showProdDetails() {
        Product p = (Product) cbProd.getSelectedItem();
        if (p == null) return;
        lblBrand.setText("Brand: " + p.brand);
        lblRating.setText("Rating: " + p.rating + " ★");
        lblPrice.setText("Price: ₹" + p.price);
        taDesc.setText(p.description);
    }

    // Update cart display and total
    private void refreshCart() {
        taCart.setText("");
        double tot = 0;
        int idx = 1;

        for (Product p : cart) {
            taCart.append(String.format("%d. %s ×%d  ₹%.2f%n", idx++, p.name, p.quantity, p.price * p.quantity));
            tot += p.price * p.quantity;
        }

        lblTotal.setText("Total: ₹" + String.format("%.2f", tot));
    }

    // Display bill and invoice in dialog
    private void checkoutBill() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty.");
            return;
        }

        StringBuilder bill = new StringBuilder("FINAL BILL\n---------------------------\n");
        double tot = 0;
        int idx = 1;

        for (Product p : cart) {
            double sub = p.price * p.quantity;
            bill.append(String.format("%d. %-20s %2d × ₹%.2f = ₹%.2f%n", idx++, p.name, p.quantity, p.price, sub));
            tot += sub;
        }

        bill.append("---------------------------\nTOTAL = ₹" + String.format("%.2f", tot));

        JTextArea ba = new JTextArea(bill.toString());
        ba.setFont(new Font("Monospaced", Font.PLAIN, 12));
        ba.setEditable(false);

        JOptionPane.showMessageDialog(this, new JScrollPane(ba), "Invoice", JOptionPane.PLAIN_MESSAGE);
    }

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ecommerce1::new);
    }
}