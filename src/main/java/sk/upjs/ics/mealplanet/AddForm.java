package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AddForm extends javax.swing.JFrame {

    private List<Ingredient> ingredients = new ArrayList<>();
    private Map<Ingredient,String> addedIngredients = new HashMap<Ingredient, String>();
    private List<MealType> mealTypes = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    private List<String> addedIngredientsNames = new ArrayList<String>();
    
    public AddForm() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("271294");
        jdbcTemplate = new JdbcTemplate(dataSource);
        initComponents();
        for (int i = 0; i <= 6; i++) {
            MealType mealType = new MealType();
            mealType.setIdT(i);
            if (i == 0) {
                mealType.setName("---meal types---");
            }
            if (i == 1) {
                mealType.setName("appetizer");
            }
            if (i == 2) {
                mealType.setName("soup");
            }
            if (i == 3) {
                mealType.setName("main course");
            }
            if (i == 4) {
                mealType.setName("dessert");
            }
            if (i == 5) {
                mealType.setName("snack");
            }
            if (i == 6) {
                mealType.setName("other");
            }
            mealTypes.add(mealType);
            mealtypeComboBox.addItem(mealType.getName());
        }
        String sql = "SELECT * FROM ingredients ORDER BY ingredients.name";
        BeanPropertyRowMapper<Ingredient> mapper = BeanPropertyRowMapper.newInstance(Ingredient.class);//tovaren
        ingredients = jdbcTemplate.query(sql, mapper);
        ingredientComboBox.addItem("");

        for (Ingredient ingredient : ingredients) {
            ingredientComboBox.addItem(ingredient.getName());
        }

        ingredientComboBox.setEditable(true);
        AutoCompleteDecorator.decorate(ingredientComboBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        recipeNameLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        prepTimeLabel = new javax.swing.JLabel();
        prepTimeTextField = new javax.swing.JTextField();
        minutesLabel = new javax.swing.JLabel();
        mealtypeComboBox = new javax.swing.JComboBox();
        addIngredientButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ingredientComboBox = new javax.swing.JComboBox();
        amountTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedIngredientsList = new javax.swing.JList();
        deleteIngredientButton = new javax.swing.JButton();
        ratingSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addRecipeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recipeNameLabel.setText("Recipe name:");

        prepTimeLabel.setText("Preparation time: ");

        minutesLabel.setText("minutes");

        addIngredientButton.setText("Add ingredient");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingredients:");

        ingredientComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingredientComboBoxMouseClicked(evt);
            }
        });

        amountTextField.setText("amount");
        amountTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amountTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                amountTextFieldMouseEntered(evt);
            }
        });
        amountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountTextFieldFocusGained(evt);
            }
        });
        amountTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                amountTextFieldCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        amountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountTextFieldKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(addedIngredientsList);

        deleteIngredientButton.setText("Delete ingredient");
        deleteIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngredientButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Rating:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ratingSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), jLabel3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        addRecipeButton.setText("Add recipe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ingredientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(addIngredientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(246, 246, 246)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(recipeNameLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(prepTimeLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(mealtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(247, 247, 247)
                                    .addComponent(prepTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minutesLabel))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(deleteIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recipeNameLabel)
                .addGap(1, 1, 1)
                .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prepTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prepTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mealtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addIngredientButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ingredientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteIngredientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountTextFieldMouseClicked
        amountTextField.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextFieldMouseClicked

    private void ingredientComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingredientComboBoxMouseClicked

    }//GEN-LAST:event_ingredientComboBoxMouseClicked

    private void amountTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextFieldKeyPressed

    private void amountTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountTextFieldMouseEntered

    }//GEN-LAST:event_amountTextFieldMouseEntered

    private void amountTextFieldCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_amountTextFieldCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextFieldCaretPositionChanged

    private void amountTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTextFieldFocusGained
        amountTextField.setText(null);
    }//GEN-LAST:event_amountTextFieldFocusGained

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientComboBox.getSelectedItem())) {
                addedIngredients.put(ingredient,amountTextField.getText());
                addedIngredientsNames.add(ingredient.getName() +" - " +amountTextField.getText());
            }
           
        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());

    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void deleteIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngredientButtonActionPerformed
        for (Ingredient ingredient : addedIngredients.keySet()) {
            String ingredAndAmount = ingredient.getName()+" - "+addedIngredients.get(ingredient);
            if (ingredAndAmount.equals(addedIngredientsList.getSelectedValue())) {
                addedIngredients.remove(ingredient);
                addedIngredientsNames.remove(ingredAndAmount);
                addedIngredientsList.setListData(addedIngredientsNames.toArray());
                return;
            }
           
        }
    }//GEN-LAST:event_deleteIngredientButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JList addedIngredientsList;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JComboBox ingredientComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox mealtypeComboBox;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JTextField prepTimeTextField;
    private javax.swing.JSlider ratingSlider;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
