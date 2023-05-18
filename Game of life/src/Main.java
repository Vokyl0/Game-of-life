public class Main {
    public static void main(String[] args) throws Exception{
        int height = 25;
        int width = 25;
        String rules = "23/3";
        int speed = 2;
        LifeGame lifeGame = new LifeGame(rules, height, width);
        ///////// simple oscillator
//        lifeGame.invertPoint(5,3);
//        lifeGame.invertPoint(5,4);
//        lifeGame.invertPoint(5,5);
        ///////// simple glider
        lifeGame.invertPoint(10, 10);
        lifeGame.invertPoint(10, 11);
        lifeGame.invertPoint(10, 12);
        lifeGame.invertPoint(9, 12);
        lifeGame.invertPoint(8, 11);
        //////// another glider
//        lifeGame.invertPoint(10, 10);
//        lifeGame.invertPoint(9, 9);
//        lifeGame.invertPoint(8, 9);
//        lifeGame.invertPoint(7, 9);
//        lifeGame.invertPoint(7, 10);
//        lifeGame.invertPoint(7, 11);
//        lifeGame.invertPoint(7, 12);
//        lifeGame.invertPoint(8, 13);
//        lifeGame.invertPoint(10, 13);
        lifeGame.setSpeed(speed);
        lifeGame.runGame();
    }
}
