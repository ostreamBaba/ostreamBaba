package access;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class BoardGame extends Game{

    public BoardGame(int i) {
        super(i);
        System.out.println("boardgame"+i);
    }

    public BoardGame(){
        System.out.println("boardgame no i");
    }

    public void printf(){
        System.out.println(BoardGame.class);
    }

}
