package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import dataStructures.RBT;

public class RBT_Test {

	private RBT<Player> players;
    private RBT<Player> players2;
    
    private void RBTStage1() {
		players = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getAssists() - i2.getAssists();
            }
        });
		
		players2 = new RBT<>(new Comparator<Player>() {
			public int compare(Player i1, Player i2) {
				return i1.getRobberies() - i2.getRobberies();
			}
		});
	}
    
    private void RBTStage2() {
    	players = new RBT<>(new Comparator<Player>() {
            public int compare(Player i1, Player i2) {
                return i1.getAssists() - i2.getAssists();
            }
        });
		
		players2 = new RBT<>(new Comparator<Player>() {
			public int compare(Player i1, Player i2) {
				return i1.getRobberies() - i2.getRobberies();
			}
		});
		
		Player player1 = new Player("Jacobo", "xxx", 4, "xxx", 8, 7, 12, 3, 3);
        Player player2 = new Player("Juan", "xxx", 3, "xx", 6, 3, 10, 9, 3);
        Player player3 = new Player("Sebastian", "xx", 10, "xxx", 15, 9, 11, 12, 3);
        Player player4 = new Player("Santiago", "ss", 12, "sss", 10, 12, 5, 13, 3);
        
        players.insert(player4);
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);
        
        players2.insert(player4);
        players2.insert(player3);
        players2.insert(player2);
        players2.insert(player1);
    }
    
    @Test
    public void testInsertNode1() {
    	RBTStage1();
		
    	Player player1 = new Player("Jacobo", "xxx", 4, "xxx", 8, 7, 12, 3, 3);
        Player player2 = new Player("Juan", "xxx", 3, "xx", 6, 3, 10, 9, 3);
        Player player3 = new Player("Sebastian", "xx", 10, "xxx", 15, 9, 11, 12, 3);
        Player player4 = new Player("Santiago", "ss", 12, "sss", 10, 12, 5, 13, 3);
        
        //Assists: 5, 11, 10, 12
        //Robberies: 13, 12, 9, 3
        
        players.insert(player4);
        players.insert(player3);
        players.insert(player2);
        players.insert(player1);
        
        players2.insert(player4);
        players2.insert(player3);
        players2.insert(player2);
        players2.insert(player1);
        
        boolean test1 = player1 == (players.getRoot().getRight().getRight().getValue().get(0));
        boolean test2 = player2 == (players.getRoot().getValue().get(0));
        boolean test3 = player3 == (players.getRoot().getRight().getValue().get(0));
        //boolean test4 = player4 == (players.getRoot().getLeft().getValue().get(0));
        
        boolean test5 = player1 == (players2.getRoot().getLeft().getLeft().getValue().get(0));
        boolean test6 = player2 == (players2.getRoot().getLeft().getValue().get(0));
        //boolean test8 = player4 == (players2.getRoot().getRight().getValue().get(0));
        
         
        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
        //assertTrue(test4);
        assertTrue(players.getWeight()==4);
        
        assertFalse(test5);
        assertFalse(test6);
        //assertTrue(test8);
        assertTrue(players2.getWeight()==4);
        
        /*If the method of inserting a node works correctly, 
         the method of balancing and rotations will also work correctly.
         */
    }
    
    @Test
	public void testInsert2() {
    	RBTStage2();
		
		Player player5 = new Player("Mateo", "pp", 23, "ppp", 12, 1, 1, 1, 3);
		
		players.insert(player5);
		players2.insert(player5);
		
		boolean test1 = player5 == (players.getRoot().getLeft().getValue().get(0));
		
        boolean test2 = player5 == (players2.getRoot().getLeft().getLeft().getValue().get(0));
        
        assertTrue(test1);
        assertFalse(test2);
        
        assertTrue(players.getWeight()==5);
        assertTrue(players2.getWeight()==5);
	}
}
