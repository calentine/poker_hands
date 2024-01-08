public class TestCases {

    /* 
     * High Card Test
    */
    public static void test1() {
       
        String playerOneInput = "2H 3D 5S 9C KD";  // Valid input for constructing a hand
        String playerTwoInput = "2C 3H 4S 8C AH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * One Pair
    */
    public static void test2() {
       
        String playerOneInput = "2S 8S AD QC 3S";  // Valid input for constructing a hand
        String playerTwoInput = "2H 2S 4C TD 6H";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Two pair
    */
    public static void test3() {
       
        String playerOneInput = "KH 3D 3S AC KD";  // Valid input for constructing a hand
        String playerTwoInput = "QC QH JS JC AH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Three of a Kind
    */
    public static void test4() {
       
        String playerOneInput = "AH AD KS KC QD";  // Valid input for constructing a hand
        String playerTwoInput = "2D 2H 2C 9S KH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Straight
    */
    public static void test5() {
       
        String playerOneInput = "2C 3D 4H 5S AC";  // Valid input for constructing a hand
        String playerTwoInput = "AH AD KS KC QD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Flush
    */
    public static void test6() {
       
        String playerOneInput = "TC JD QH KS AC";  // Valid input for constructing a hand
        String playerTwoInput = "2C 3C TC 7C AC";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Full House
    */
    public static void test7() {
       
        String playerOneInput = "2C 3C TC 7C AC";  // Valid input for constructing a hand
        String playerTwoInput = "2H 4S 4C 2D 4H";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * 
    */
    public static void test8() {
       
        String playerOneInput = "2c 3d 4h 5s 6c";  // Valid input for constructing a hand
        String playerTwoInput = "2d 3c 4s 5h 6d";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * 
    */
    public static void test9() {
       
        String playerOneInput = "2c 3d 4h 5s 6c";  // Valid input for constructing a hand
        String playerTwoInput = "2d 3c 4s 5h 6d";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Tie
    */
    public static void test10() {
       
        String playerOneInput = "2H 3D 5S 9C KD";  // Valid input for constructing a hand
        String playerTwoInput = "2D 3H 5C 9S KH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
    * High Card:
    * has same high card so gets next high card for comparison
    */
    public static void test11() {
       
        String playerOneInput = "2c 3d 4h 5s 6c";  // Valid input for constructing a hand
        String playerTwoInput = "2d 3c 4s 5h 6d";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }

   

    
}
