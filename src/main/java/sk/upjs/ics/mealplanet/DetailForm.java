package sk.upjs.ics.mealplanet;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;

public class DetailForm extends javax.swing.JFrame {

    private Recipe recipe;
    private RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();

    public DetailForm() {

        initComponents();
        stepsTextArea.setLineWrap(true);

        stepsTextArea.setEditable(false);
        stepsTextArea.setCaretPosition(0);
        // JScrollPane scrollPane = new JScrollPane(stepsTextArea);
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        List<Relation> relations = relationDao.getMatching(recipe.getIdR());
        List<String> addedIngredients = new ArrayList<>();
        List<Ingredient> ingredients = recipe.getIngredients();
        for (Relation relation : relations) {
            for (Ingredient ingredient : ingredients) {
                if (relation.idI == ingredient.getIdI()) {
                    addedIngredients.add(ingredient.getName() + " - " + relation.getAmount());
                }

            }

        }

        nameLabel.setText(recipe.getName());
        prepTimeLabel.setText("Preparation time: " + recipe.getPrepTime() + " minutes");
        mealTypeLabel.setText("Meal type: " + recipe.getMealtype().getName());
        ratingLabel.setText("Rating: " + recipe.getRating());
        ingredientsList.setListData(addedIngredients.toArray());
        stepsTextArea.setText(recipe.getSteps());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        prepTimeLabel = new javax.swing.JLabel();
        mealTypeLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        ingredientsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList();
        stepsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stepsTextArea = new javax.swing.JTextArea();
        editRecipeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setText("name");

        prepTimeLabel.setText("Preparation time:");

        mealTypeLabel.setText("Meal type:");

        ratingLabel.setText("Rating:");

        ingredientsLabel.setText("Ingredients:");

        jScrollPane1.setViewportView(ingredientsList);

        stepsLabel.setText("Steps:");

        stepsTextArea.setColumns(20);
        stepsTextArea.setRows(5);
        jScrollPane3.setViewportView(stepsTextArea);

        editRecipeButton.setText("Edit recipe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prepTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(mealTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingredientsLabel)
                            .addComponent(stepsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prepTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mealTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ratingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingredientsLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(stepsLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editRecipeButton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editRecipeButton;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JList ingredientsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mealTypeLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextArea stepsTextArea;
    // End of variables declaration//GEN-END:variables
}
