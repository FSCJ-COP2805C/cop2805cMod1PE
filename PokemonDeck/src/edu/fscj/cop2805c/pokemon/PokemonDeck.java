// PokemonDeck.java
// D. Singletary
// 1/1/23
// Program that plays a simple Pokemon game

package edu.fscj.cop2805c.pokemon;

import java.util.ArrayList;
import java.util.Random;

enum COLOR { Red, Blue, Yellow, Green, Purple, Black }

class PokemonCard {
    String name;
    private COLOR color;
    private Integer hitPoints;

    boolean dealt = false;

    public PokemonCard(String name, COLOR color, Integer hitPoints) {
        this.name = name;
        this.color = color;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public COLOR getColor() {
        return color;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public boolean isDealt() {
        return dealt;
    }

    public void setDealt(boolean dealt) {
        this.dealt = dealt;
    }

    @Override
    public String toString() {
        String s = name + ", " + color + ", HP=" + hitPoints;
        return s;
    }
}
public class PokemonDeck {
    public final static Integer cardsPerDeck = 6;
    ArrayList<PokemonCard> deck = new ArrayList<>();

    // select n cards from deck for attack
    // uses naive algorithm to only deal undealt cards to
    // avoid repeats, similar to R / Python sample functions
    ArrayList<PokemonCard> attack(int n) {
        // get random array of undealt index values
        ArrayList<PokemonCard> returnList = new ArrayList<>();
        var index = -1;
        // seed random generator with current time for variety
        Random r = new Random(System.currentTimeMillis());
        for (var i = 0; i < n; ) {
            index = r.nextInt(deck.size());
            PokemonCard pc = deck.get(index);
            //System.out.println("getting " + index);
            if (pc.isDealt() == false) {
                returnList.add(pc);
                pc.setDealt(true);
                i++;
            }
        }
        return returnList;
    }

    // show the cards in the hand parameter
    public void showAttackers(ArrayList<PokemonCard> hand) {
        for (PokemonCard pc : hand)
            System.out.println(pc.getName() + ", Attack! (" +
                    pc.getColor() + ", " + pc.getHitPoints() + ")");
    }
    @Override
    public String toString() {
        String s = "Here is your Pokemon Deck:\n";
        for (PokemonCard p : deck) {
            s += "\t";
            s += p;
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {

        // create parallel arrays to store the data, start with the names
        String[] names = {
                "Charmander",
                "Squirtle",
                "Pikachu",
                "Bulbasaur",
                "Koffing",
                "Charizard"
        };

        // parallel array for colors
        COLOR[] colors = {
                COLOR.Red, // Charmander
                COLOR.Blue, // Squirtle
                COLOR.Yellow, // Pikachu
                COLOR.Green, // Bulbasaur
                COLOR.Purple, // Koffing
                COLOR.Black // Charizard
        };

        // parallel array for hit points
        Integer[] hitPoints = {
                50, // Charmander
                50, // Squirtle
                60, // Pikachu
                60, // Bulbasaur
                50, // Koffing
                75 // Charizard
        };

        // welcome user
        System.out.println("""
                Welcome to the Pokemon game!
                I will now create a deck and \
                deal a random two-card attack hand.
                """);

        // create deck
        PokemonDeck pc = new PokemonDeck();
        for (var i = 0; i < names.length; i++)
            pc.deck.add(new PokemonCard(names[i], colors[i], hitPoints[i]));

        // show deck
        System.out.println(pc);

        // attack with 2 cards
        ArrayList<PokemonCard> attackCards = pc.attack(2);
        pc.showAttackers(attackCards);
    }
}
