package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EditForm extends javax.swing.JFrame {

    private RecipeDao recipeDao = RecipeDaoFactory.INSTANCE.getRecipeDao();

    private List<Ingredient> ingredients = new ArrayList<>();// ###########vsetky ingrediencie z databazy 
    private Map<Ingredient, String> addedIngredients = new HashMap<Ingredient, String>();
    private List<MealType> mealTypes = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    private List<String> addedIngredientsNames = new ArrayList<String>();//na pracu s vybratymi ingredienciami v jListe
    private List<Relation> relations = new ArrayList<>();
    private String text;
    ///////////////////////////////////toto je ine ako v addForm
    private Recipe recipe;
    private RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();
    //////////////////////////////////

    public EditForm() {
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

    public void setRecipeToForm(Recipe recipe) {
        this.recipe = recipe;
        List<Relation> relations = relationDao.getMatching(recipe.getIdR());
      //  List<String> addedIngredients = new ArrayList<>();
        List<Ingredient> ingredients = recipe.getIngredients();
System.out.println(this.recipe.getIdR());
        for (Relation relation : relations) {
            for (Ingredient ingredient : ingredients) {
                if (relation.idI == ingredient.getIdI()) {
                    addedIngredients.put(ingredient, relation.getAmount());
                    addedIngredientsNames.add(ingredient.getName() + " - " + relation.getAmount());
                }

            }

        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());

        recipeNameTextField.setText(recipe.getName());
        mealtypeComboBox.setSelectedIndex(recipe.getType());
        prepTimeSpinner.setValue(recipe.getPrepTime());
        stepsTextField.setText(recipe.getSteps());
        ratingSlider.setValue(recipe.getRating());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        prepTimeSpinner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedIngredientsList = new javax.swing.JList();
        addNewIngredientButton = new javax.swing.JButton();
        ingredientComboBox = new javax.swing.JComboBox();
        amountTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addIngredientButton = new javax.swing.JButton();
        saveRecipeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        stepsTextField = new javax.swing.JTextField();
        minutesLabel = new javax.swing.JLabel();
        stepsLabel = new javax.swing.JLabel();
        mealtypeComboBox = new javax.swing.JComboBox();
        deleteIngredientButton = new javax.swing.JButton();
        ratingSlider = new javax.swing.JSlider();
        prepTimeLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        recipeNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(addedIngredientsList);

        addNewIngredientButton.setText("Add new ingredient");
        addNewIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewIngredientButtonActionPerformed(evt);
            }
        });

        amountTextField.setText("amount");
        amountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountTextFieldFocusGained(evt);
            }
        });

        addIngredientButton.setText("Add ingredient");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });

        saveRecipeButton.setText("Save");
        saveRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRecipeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingredients:");

        minutesLabel.setText("minutes");

        stepsLabel.setText("Steps:");

        deleteIngredientButton.setText("Delete ingredient");
        deleteIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngredientButtonActionPerformed(evt);
            }
        });

        prepTimeLabel.setText("Preparation time: ");

        recipeNameLabel.setText("Recipe name:");

        jLabel2.setText("Rating:");

        cancelButton.setText("Cancel");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ratingSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), jLabel4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stepsTextField)
                                .addGap(101, 101, 101)
                                .addComponent(saveRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(285, 285, 285)
                                        .addComponent(amountTextField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(prepTimeLabel)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(prepTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(minutesLabel))
                                                            .addComponent(ingredientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(mealtypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(101, 101, 101))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addIngredientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addNewIngredientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recipeNameLabel)
                                .addGap(42, 42, 42)
                                .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepsLabel)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveRecipeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addComponent(cancelButton)
                    .addComponent(ratingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewIngredientButtonActionPerformed
        AddIngredientForm addForm = new AddIngredientForm();
        addForm.setVisible(true);
        addForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_addNewIngredientButtonActionPerformed

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

    private void saveRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRecipeButtonActionPerformed
        relationDao.delete(recipe.getIdR()); //vymaze vsetky predosle relations aby nahradil novymi
        
        Recipe alteredRecipe = new Recipe();
        
        String name = recipeNameTextField.getText();
        int prepTime = (int) prepTimeSpinner.getValue();
        String steps = stepsTextField.getText();
        int rating = ratingSlider.getValue();
        int type = mealtypeComboBox.getSelectedIndex();

        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Recipe name requested");
            return;
        }
        if (prepTime == 0) {
            JOptionPane.showMessageDialog(this, "Preparation time should be more than 0 minutes");
            return;
        }
        if (steps.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Describe your recipe");
            return;
        }
        if (type == 0) {
            JOptionPane.showMessageDialog(this, "Meal type requested");
            return;
        }

        if (addedIngredients.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pick at least one ingredient.");
        }

        alteredRecipe.setName(name);
        alteredRecipe.setSteps(steps);
        alteredRecipe.setRating(rating);
        alteredRecipe.setPrepTime(prepTime);
        alteredRecipe.setType(type);
        alteredRecipe.setIdR(recipe.getIdR());  //// lebo ostava predosle idR

        recipeDao.update(alteredRecipe);/// update receptu

        for (Ingredient ingredient : addedIngredients.keySet()) {
            Relation relation = new Relation();
            relation.setAmount(addedIngredients.get(ingredient));//addedIngredients.get(ingredient)
            relation.setIdI(ingredient.getIdI());
            relation.setIdR(recipe.getIdR());

            
            relationDao.addRelation(relation);
        }

    }//GEN-LAST:event_saveRecipeButtonActionPerformed

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JButton addNewIngredientButton;
    private javax.swing.JList addedIngredientsList;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JComboBox ingredientComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox mealtypeComboBox;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JSpinner prepTimeSpinner;
    private javax.swing.JSlider ratingSlider;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JButton saveRecipeButton;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextField stepsTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
