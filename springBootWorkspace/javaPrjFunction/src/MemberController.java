public class MemberController {



    private MemberController() {

    }

    private static MemberController x;

    public static MemberController getObj(){
        if(x == null){
            x = new MemberController();
        }
        return x;
    }
}
