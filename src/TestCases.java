public class TestCases {
    /*
     * Test cases Class: contains all tests to run utilizing the TestingClass
     */
    
    /* 
     * High Card Test
    */
    public static void test1() {
        
        String playerOneInput = "2H 3D 5S 9C KD";  // Valid input for constructing a hand
        String playerTwoInput = "2C 3H 4S 8C AH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
    * High Card:
    * has same high card so gets next high card for comparison
    */
    public static void test1a() {
       
        String playerOneInput = "2C 3D 4H AS KC";  // Valid input for constructing a hand
        String playerTwoInput = "2S 3C 4S AH QD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
    * High Card:
    * tie same exact cards just with different suits.
    */
    public static void test1b() {
       
        String playerOneInput = "2C 3D 4H JS AC";  // Valid input for constructing a hand
        String playerTwoInput = "2S 3C 4S AH JD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * One Pair
    */
    public static void test2() {
       
        String playerOneInput = "2S 8S AD QC 3S";  // Valid input for constructing a hand
        String playerTwoInput = "2H 2C 4C TD 6H";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * One Pair:
     * Same pair but with higher rank
    */
    public static void test2a() {
       
        String playerOneInput = "2D 2C AD QC 3S";  // Valid input for constructing a hand
        String playerTwoInput = "2H 2S 4C KD 6H";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * One Pair:
     * tie same rank.
    */
    public static void test2b() {
       
        String playerOneInput = "2D 2C AD QC KS";  // Valid input for constructing a hand
        String playerTwoInput = "2H 2S AC KD QH";  // Valid input for constructing a hand

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
     * Two pair:
     * same pair but with higher rank
    */
    public static void test3a() {
       
        String playerOneInput = "AH 3D 3S AC KD";  // Valid input for constructing a hand
        String playerTwoInput = "AS 3H AD 3C QH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Two pair:
     * tie same rank.
    */
    public static void test3b() {
       
        String playerOneInput = "AH QD QS AC KD";  // Valid input for constructing a hand
        String playerTwoInput = "AS QH AD QC KH";  // Valid input for constructing a hand

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
     * Three of a Kind:
     * with larger 3 of a kind.
    */
    public static void test4a() {
       
        String playerOneInput = "3H 3D 3S KC QD";  // Valid input for constructing a hand
        String playerTwoInput = "2D 2H 2C 9S KH";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Straight
    */
    public static void test5() {
       
        String playerOneInput = "2C 3D AH 5S 4C";  // Valid input for constructing a hand
        String playerTwoInput = "AH AD KS KC QD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Straight:
     *  with a higher rank.
    */
    public static void test5a() {
       
        String playerOneInput = "2C 3D AH 5S 4C";  // Valid input for constructing a hand
        String playerTwoInput = "2H 4D 3S 5C 6D";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Straight:
     *  tie same rank.
    */
    public static void test5b() {
       
        String playerOneInput = "2C 3D AH 5S 4C";  // Valid input for constructing a hand
        String playerTwoInput = "2H 4D 3S 5C AD";  // Valid input for constructing a hand

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
     * Flush:
     * with a higher rank.
    */
    public static void test6a() {
       
        String playerOneInput = "TC 5C QC KC 9C";  // Valid input for constructing a hand
        String playerTwoInput = "2C 3C 8C 7C AC";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Flush:
     * with a higher rank.
    */
    public static void test6b() {
       
        String playerOneInput = "JC 9C QC KC AC";  // Valid input for constructing a hand
        String playerTwoInput = "9S TS QS KS AS";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Flush:
     * tie same rank.
    */
    public static void test6c() {
       
        String playerOneInput = "JC 9C QC KC AC";  // Valid input for constructing a hand
        String playerTwoInput = "JS 9S QS KS AS";  // Valid input for constructing a hand

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
     * Full House:
     * larger full house wins
    */
    public static void test7a() {
       
        String playerOneInput = "2C 2S 4C 4H 4S";  // Valid input for constructing a hand
        String playerTwoInput = "2H 5S 5C 5D 3H";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Four of a Kind
    */
    public static void test8() {
       
        String playerOneInput = "2C 2D 2H 2S 6C";  // Valid input for constructing a hand
        String playerTwoInput = "KD KC KS AH AD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Four of a Kind:
     * with larger four of a kind.
    */
    public static void test8a() {
       
        String playerOneInput = "2C 2D 2H 2S 6C";  // Valid input for constructing a hand
        String playerTwoInput = "3D 3C 3S 3H 6D";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Straight Flush
    */
    public static void test9() {
       
        String playerOneInput = "2C 2D 2H 2S 6C";  // Valid input for constructing a hand
        String playerTwoInput = "9D TD 8D JD QD";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }
    /* 
     * Higher Straight Flush
    */
    public static void test10() {
       
        String playerOneInput = "TD JD QD KD AD";  // Valid input for constructing a hand
        String playerTwoInput = "9S TS JS QS KS";  // Valid input for constructing a hand

        new TestingClass(playerOneInput, playerTwoInput);
    }

    /************************* end of test cases feel free to add more ************************************/

}
