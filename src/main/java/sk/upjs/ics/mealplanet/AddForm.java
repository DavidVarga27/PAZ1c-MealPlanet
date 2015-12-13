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

    private RecipeDao recipeDao = RecipeDaoFactory.INSTANCE.getRecipeDao();
    private List<Ingredient> ingredients = new ArrayList<>();// ###########vsetky ingrediencie z databazy 
    private Map<Ingredient, String> addedIngredients = new HashMap<Ingredient, String>();
    private List<MealType> mealTypes = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    private List<String> addedIngredientsNames = new ArrayList<String>();//na pracu s vybratymi ingredienciami v jListe
    private List<Relation> relations = new ArrayList<>();
    private String text;

    public AddForm() {
/////////tu je pripojenie na databazu,,,treba spravit dajak zeby to tu nebolo ????
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("271294");
        jdbcTemplate = new JdbcTemplate(dataSource);
        initComponents();
        text = amountTextField.getText();
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
        stepsTextField = new javax.swing.JTextField();
        stepsLabel = new javax.swing.JLabel();
        prepTimeSpinner = new javax.swing.JSpinner();
        addNewIngredientButton = new javax.swing.JButton();

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

        amountTextField.setText("amount");
        amountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountTextFieldFocusGained(evt);
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
        addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeButtonActionPerformed(evt);
            }
        });

        stepsLabel.setText("Steps:");

        addNewIngredientButton.setText("Add new ingredient");
        addNewIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewIngredientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsTextField)
                        .addGap(240, 240, 240))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recipeNameLabel)
                                .addGap(42, 42, 42)
                                .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(285, 285, 285)
                                            .addComponent(amountTextField)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(prepTimeLabel)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ingredientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(prepTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(minutesLabel)
                                                            .addGap(0, 0, Short.MAX_VALUE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(mealtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(jScrollPane1))
                                            .addGap(101, 101, 101)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addNewIngredientButton))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeNameLabel)
                    .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mealtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prepTimeLabel)
                    .addComponent(minutesLabel)
                    .addComponent(prepTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ingredientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addIngredientButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(deleteIngredientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addNewIngredientButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stepsLabel)
                .addGap(12, 12, 12)
                .addComponent(stepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTextFieldFocusGained
        amountTextField.setText(null);
    }//GEN-LAST:event_amountTextFieldFocusGained

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientComboBox.getSelectedItem())) {
                addedIngredients.put(ingredient, amountTextField.getText());
                Relation relation = new Relation();
                relation.setIdI(ingredient.getIdI());
                relation.setAmount(amountTextField.getText());
                addedIngredientsNames.add(ingredient.getName() + " - " + amountTextField.getText());
            }

        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());

    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void deleteIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngredientButtonActionPerformed
        for (Ingredient ingredient : addedIngredients.keySet()) {
            String ingredAndAmount = ingredient.getName() + " - " + addedIngredients.get(ingredient);
            if (ingredAndAmount.equals(addedIngredientsList.getSelectedValue())) {
                addedIngredients.remove(ingredient);
                addedIngredientsNames.remove(ingredAndAmount);
                addedIngredientsList.setListData(addedIngredientsNames.toArray());
                return;
            }

        }
    }//GEN-LAST:event_deleteIngredientButtonActionPerformed

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        String sql = "select * from recipes where idr >= all (select max(idr) from recipes)";

        BeanPropertyRowMapper<Recipe> mapper = BeanPropertyRowMapper.newInstance(Recipe.class);//tovaren pre rowmapper
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper);
///////////////////toto treba dat do nejakeho MySql triedy, ale neviem ktorej asi do Mysqlrecipedao
        Recipe recipe = new Recipe();
        String name = recipeNameTextField.getText();
        int prepTime = (int) prepTimeSpinner.getValue();
        String steps = stepsTextField.getText();
        int rating = ratingSlider.getValue();
        int type = mealtypeComboBox.getSelectedIndex();
        long newIdr = recipes.get(0).getIdR() + 1;

        recipe.setName(name);
        recipe.setSteps(steps);
        recipe.setRating(rating);
        recipe.setPrepTime(prepTime);
        recipe.setType(type);
        recipe.setIdR(newIdr);

        recipeDao.add(recipe);/// pridanie receptu

        for (Ingredient ingredient : addedIngredients.keySet()) {
            Relation relation = new Relation();
            relation.setAmount(addedIngredients.get(ingredient));
            relation.setIdI(ingredient.getIdI());
            relation.setIdR(newIdr);

            RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();
            relationDao.addRelation(relation);
        }


    }//GEN-LAST:event_addRecipeButtonActionPerformed

    private void addNewIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewIngredientButtonActionPerformed
       AddIngredientForm addForm = new AddIngredientForm();
        addForm.setVisible(true);
        addForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_addNewIngredientButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JButton addNewIngredientButton;
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
    private javax.swing.JSpinner prepTimeSpinner;
    private javax.swing.JSlider ratingSlider;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextField stepsTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
