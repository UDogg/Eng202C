import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class OfflineFormApplication extends JFrame {
    private JTextField ticketNumberField;
    private JTextArea justificationArea;
    private JTextField bbaNameField;
    private JTextField financeNameField;
    private JCheckBox[] reasonBoxes = new JCheckBox[8];
    private JButton generateButton;
    private JLabel characterCountLabel;
    private boolean[] sideSelection = new boolean[2]; // 0: left, 1: right

    public OfflineFormApplication() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setupWindow();
    }

    private void initializeComponents() {
        ticketNumberField = new JTextField(30);
        justificationArea = new JTextArea(6, 40);
        justificationArea.setLineWrap(true);
        justificationArea.setWrapStyleWord(true);
        bbaNameField = new JTextField(25);
        financeNameField = new JTextField(25);
        generateButton = new JButton("Generate Image to Sign");
        characterCountLabel = new JLabel("0 characters written, 500 left");
        
        String[] reasons = {
            "Closing PR/POs",
            "GST charge-off to project",
            "GRs for STO",
            "GST paid to vendor but not claimed",
            "Closing of associated Revex internal orders",
            "Irrecoverable GST debit where capitalization not done",
            "Surplus material transfer outside project",
            "Reversal of FI Liability"
        };
        
        for (int i = 0; i < 8; i++) {
            reasonBoxes[i] = new JCheckBox(reasons[i]);
            reasonBoxes[i].setEnabled(false);
        }
    }

    private void setupLayout() {
        setTitle("Format for Continuation of Non-Continuing Projects");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Main container
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(244, 247, 246));
        
        // Title
        JLabel titleLabel = new JLabel("<html><center>Format for Continuation of Non-Continuing Projects<br>for posting transactions.</center></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("<html><center><i>Please select the appropriate option which must be signed by the relevant role holder.</i></center></html>");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel instructionLabel = new JLabel("<html><center><u>Please fill the form top to bottom.</u></center></html>");
        instructionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel requiredNote = new JLabel("This star (*) indicates required fields");
        requiredNote.setFont(new Font("Arial", Font.PLAIN, 12));
        requiredNote.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Ticket Number Section
        JPanel ticketPanel = new JPanel(new BorderLayout());
        ticketPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        ticketPanel.setMaximumSize(new Dimension(800, 80));
        ticketPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel ticketLabel = new JLabel("AR Number/ WBSE Number *");
        ticketLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        ticketPanel.add(ticketLabel, BorderLayout.NORTH);
        ticketPanel.add(ticketNumberField, BorderLayout.CENTER);
        
        // Reason Section
        JPanel reasonPanel = new JPanel();
        reasonPanel.setLayout(new BoxLayout(reasonPanel, BoxLayout.Y_AXIS));
        reasonPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK), 
            "Reason for opening (select all that apply) *", 
            TitledBorder.CENTER, 
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 12)
        ));
        reasonPanel.setMaximumSize(new Dimension(800, 200));
        reasonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel reasonGrid = new JPanel(new GridLayout(4, 2, 10, 10));
        for (int i = 0; i < 8; i++) {
            reasonGrid.add(reasonBoxes[i]);
        }
        reasonPanel.add(reasonGrid);
        
        // Justification Section
        JPanel justificationPanel = new JPanel();
        justificationPanel.setLayout(new BoxLayout(justificationPanel, BoxLayout.Y_AXIS));
        justificationPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK), 
            "Detailed Justification: *", 
            TitledBorder.CENTER, 
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 12)
        ));
        justificationPanel.setMaximumSize(new Dimension(800, 200));
        justificationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(justificationArea);
        justificationPanel.add(scrollPane);
        justificationPanel.add(characterCountLabel);
        
        // Signature Section
        JPanel signatureHeaderPanel = new JPanel();
        signatureHeaderPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK), 
            "No new Expenditure / Commitment will be made.",
            TitledBorder.CENTER, 
            TitledBorder.DEFAULT_POSITION,
            new Font("Arial", Font.BOLD, 12)
        ));
        signatureHeaderPanel.setMaximumSize(new Dimension(800, 50));
        signatureHeaderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Signature Areas
        JPanel signaturePanel = new JPanel(new GridLayout(1, 2, 20, 0));
        signaturePanel.setMaximumSize(new Dimension(800, 200));
        signaturePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel bbaPanel = new JPanel();
        bbaPanel.setLayout(new BoxLayout(bbaPanel, BoxLayout.Y_AXIS));
        JLabel bbaLabel = new JLabel("Signature of BBA", JLabel.CENTER);
        bbaPanel.add(bbaLabel);
        
        JPanel bbaSignaturePanel = new JPanel();
        bbaSignaturePanel.setPreferredSize(new Dimension(300, 100));
        bbaSignaturePanel.setBorder(BorderFactory.createDashedBorder(Color.GRAY));
        bbaSignaturePanel.setBackground(Color.LIGHT_GRAY);
        bbaPanel.add(bbaSignaturePanel);
        
        JPanel bbaNamePanel = new JPanel(new BorderLayout());
        JLabel bbaNameLabel = new JLabel("Name of BBA: *");
        bbaNamePanel.add(bbaNameLabel, BorderLayout.NORTH);
        bbaNamePanel.add(bbaNameField, BorderLayout.CENTER);
        bbaPanel.add(bbaNamePanel);
        
        JPanel financePanel = new JPanel();
        financePanel.setLayout(new BoxLayout(financePanel, BoxLayout.Y_AXIS));
        JLabel financeLabel = new JLabel("Signature of Finance Role Holder", JLabel.CENTER);
        financePanel.add(financeLabel);
        
        JPanel financeSignaturePanel = new JPanel();
        financeSignaturePanel.setPreferredSize(new Dimension(300, 100));
        financeSignaturePanel.setBorder(BorderFactory.createDashedBorder(Color.GRAY));
        financeSignaturePanel.setBackground(Color.LIGHT_GRAY);
        financePanel.add(financeSignaturePanel);
        
        JPanel financeNamePanel = new JPanel(new BorderLayout());
        JLabel financeNameLabel = new JLabel("Name of Finance Member: *");
        financeNamePanel.add(financeNameLabel, BorderLayout.NORTH);
        financeNamePanel.add(financeNameField, BorderLayout.CENTER);
        financePanel.add(financeNamePanel);
        
        signaturePanel.add(bbaPanel);
        signaturePanel.add(financePanel);
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateButton.setEnabled(false);
        buttonPanel.add(generateButton);
        
        // Add all components to main panel
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(subtitleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(instructionLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(requiredNote);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(ticketPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(reasonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(justificationPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(signatureHeaderPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(signaturePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonPanel);
        
        add(new JScrollPane(mainPanel));
    }

    private void setupEventHandlers() {
        // Ticket number enables form
        ticketNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateFormState();
            }
        });
        
        // Character counter for justification
        justificationArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCharacterCount();
            }
        });
        
        // Reason selection logic
        for (int i = 0; i < reasonBoxes.length; i++) {
            final int index = i;
            reasonBoxes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleReasonSelection(index);
                }
            });
        }
        
        // Generate button
        generateButton.addActionListener(e -> generateImage());
    }
    
    private void updateFormState() {
        boolean hasTicket = !ticketNumberField.getText().trim().isEmpty();
        
        for (JCheckBox box : reasonBoxes) {
            box.setEnabled(hasTicket);
        }
        
        justificationArea.setEnabled(hasTicket);
        generateButton.setEnabled(hasTicket && hasTicket);
    }
    
    private void updateCharacterCount() {
        String text = justificationArea.getText();
        int length = text.length();
        int remaining = Math.max(0, 500 - length);
        
        characterCountLabel.setText(length + " characters written, " + remaining + " left");
        
        if (length > 500) {
            characterCountLabel.setForeground(Color.RED);
            justificationArea.setText(text.substring(0, 500));
        } else if (length > 400) {
            characterCountLabel.setForeground(new Color(255, 107, 53)); // Orange
        } else {
            characterCountLabel.setForeground(Color.BLACK);
        }
    }
    
    private void handleReasonSelection(int selectedIndex) {
        boolean isLeftSide = (selectedIndex % 2 == 0);
        List<Integer> selectedIndices = new ArrayList<>();
        
        for (int i = 0; i < reasonBoxes.length; i++) {
            if (reasonBoxes[i].isSelected()) {
                selectedIndices.add(i);
            }
        }
        
        if (selectedIndices.isEmpty()) {
            // Enable all if none selected
            for (JCheckBox box : reasonBoxes) {
                box.setEnabled(true);
            }
            bbaNameField.setEnabled(false);
            financeNameField.setEnabled(false);
            generateButton.setEnabled(!ticketNumberField.getText().trim().isEmpty());
            return;
        }
        
        // Check if mixing sides
        boolean hasLeft = false, hasRight = false;
        for (int index : selectedIndices) {
            if (index % 2 == 0) hasLeft = true;
            else hasRight = true;
        }
        
        if (hasLeft && hasRight) {
            JOptionPane.showMessageDialog(this, 
                isLeftSide ? 
                "A checkbox on the left is selected. Please unselect all left-side options to choose an option from the right." :
                "A checkbox on the right is selected. Please unselect all right-side options to choose an option from the left.",
                "Selection Error", JOptionPane.WARNING_MESSAGE);
            reasonBoxes[selectedIndex].setSelected(false);
            return;
        }
        
        // Disable opposite side
        for (int i = 0; i < reasonBoxes.length; i++) {
            boolean boxIsLeft = (i % 2 == 0);
            if (!reasonBoxes[i].isSelected()) {
                reasonBoxes[i].setEnabled(boxIsLeft == isLeftSide);
            }
        }
        
        // Enable name fields
        bbaNameField.setEnabled(true);
        financeNameField.setEnabled(!isLeftSide);
        generateButton.setEnabled(true);
        
        if (isLeftSide) {
            financeNameField.setText("");
        }
    }
    
    private void generateImage() {
        // Validation
        StringBuilder errors = new StringBuilder();
        
        if (ticketNumberField.getText().trim().isEmpty()) {
            errors.append("• AR Number/ WBSE Number is required\n");
        }
        
        boolean hasReason = false;
        for (JCheckBox box : reasonBoxes) {
            if (box.isSelected()) {
                hasReason = true;
                break;
            }
        }
        if (!hasReason) {
            errors.append("• Please select at least one reason\n");
        }
        
        if (justificationArea.getText().trim().isEmpty()) {
            errors.append("• Detailed justification is required\n");
        } else if (justificationArea.getText().length() > 500) {
            errors.append("• Justification exceeds 500 character limit\n");
        }
        
        if (bbaNameField.isEnabled() && bbaNameField.getText().trim().isEmpty()) {
            errors.append("• Name of BBA is required\n");
        }
        
        if (financeNameField.isEnabled() && financeNameField.getText().trim().isEmpty()) {
            errors.append("• Name of Finance Member is required\n");
        }
        
        if (errors.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "Please correct the following errors:\n" + errors.toString(),
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Generate image
        try {
        // Get the JScrollPane and then the mainPanel from its viewport
            JScrollPane scrollPane = (JScrollPane) getContentPane().getComponent(0);
            JPanel panel = (JPanel) scrollPane.getViewport().getView();
        
        // Set the size to preferred size for proper rendering
            panel.setSize(panel.getPreferredSize());
            panel.doLayout(); // Ensure layout is updated

            BufferedImage image = new BufferedImage(
                panel.getWidth(), 
                panel.getHeight(), 
                BufferedImage.TYPE_INT_RGB
            );
        
            Graphics2D g = image.createGraphics();
            panel.paint(g);
            g.dispose();
            
            // Save file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Form Image");
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".png")) {
                    file = new File(file.getParentFile(), file.getName() + ".png");
                }
                
                ImageIO.write(image, "png", file);
                JOptionPane.showMessageDialog(this, 
                    "Form saved as PNG successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "An error occurred while saving the form: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void setupWindow() {
        setSize(900, 800);
        setLocationRelativeTo(null);
        updateFormState(); // Initial state
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new OfflineFormApplication().setVisible(true);
        });
    }
}
