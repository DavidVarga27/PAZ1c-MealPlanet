/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

import java.util.List;

/**
 *
 * @author DaviD
 */
public interface RelationDao {
    public void addRelation(Relation relation);
    public void deleteRelation(Relation relation);
    public List<Relation> getMatching(long idR);
    
}
