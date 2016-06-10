/**
 * Contains methods that finds out the name of character and prints it.
 * 
 * @author Avinash Prabhakar aprabhak@purdue.edu
 * @version 9/24/2014
 */


public class Guesser {

    /**
     * Finds out the name of the character.
     */
    public static String play(GuessWhoGame g) {
        if (g.hairIsColor(Color.BROWN)) {
            if (g.eyeIsColor(Color.BROWN)) {
                if (g.shirtIsColor(Color.GREEN)) {
                    if (g.isWearingGlasses()) {
                        return "Bob";
                    } else {
                        return "Dave";
                    }
                } else {
                    if (g.shirtIsColor(Color.RED)) {
                        if (g.isWearingHat()) {
                            return "Robert";
                        } else {
                            return "Quinn";
                        }
                    } else {
                        return "Zander";
                    }
                }
            } else {
                if (g.shirtIsColor(Color.RED)) {
                    if (g.eyeIsColor(Color.BLUE)) {
                        if (g.isWearingGlasses()) {
                            if (g.isSmiling()) {
                                return "Mallie";
                            } else {
                                return "Wendy";
                            }
                        } else {
                            return "Nick";
                        }
                    } else {
                        if (g.isWearingGlasses()) {
                            return "Emily";
                        } else {
                            return "Philip";
                        }
                    }
                } else {
                    if (g.shirtIsColor(Color.GREEN)) {
                        if (g.eyeIsColor(Color.BLUE)) {
                            return "Alice";
                        } else {
                            if (g.eyeIsColor(Color.GREEN)) {
                                return "Frank";
                            } else {
                                return "Isabelle";
                            }
                        }
                    } else {
                        return "Tucker";
                    }
                }
            }
        } else {
            if (g.eyeIsColor(Color.BROWN)) {
                if (g.hairIsColor(Color.BLACK)) {
                    if (g.isWearingGlasses()) {
                        return "Xavier";
                    } else {
                        if (g.shirtIsColor(Color.BLUE)) {
                            return "Olivia";
                        } else {
                            return "Ursula";
                        }
                    }
                } else {
                    if (g.hairIsColor(Color.BLOND)) {
                        if (g.shirtIsColor(Color.RED)) {
                            return "Henry";
                        } else {
                            return "Jack";
                        }
                    } else {
                        if (g.isWearingHat()) {
                            return "Sarah";
                        } else {
                            return "Victor";
                        }
                    }
                }
            } else {
                if (g.hairIsColor(Color.BLACK)) {
                    if (g.eyeIsColor(Color.BLUE)) {
                        if (g.isSmiling()) {
                            return "Gertrude";
                        } else {
                            return "Carol";
                        }
                    } else {
                        return "Karen";
                    }
                } else {
                    if (g.shirtIsColor(Color.BLUE)) {
                        return "Larry";
                    } else {
                        return "Yasmine";
                    }
                }
            }   
        }
        
        //return null;
    }

    /**
     * instantiates GuesswhoGame class and starts methods.
     */
    public static void main(String[] args) {
        GuessWhoGame g = new GuessWhoGame();
        System.out.println(play(g));
//        g.guess("bob");
//        System.out.println(g.guess("bob"));
        System.out.println("score =" + g.score());
    }
}
