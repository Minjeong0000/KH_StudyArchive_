
public class BoardVo {

    private String title;
    private String content;

    private BoardVo(Builder builder){
        this.title = builder.title;
        this.content = builder.content;
    }

    public static Builder builder(){
        return new BoardVo.Builder();
    }

    static class Builder {
        private String title;
        private String content;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public BoardVo build(){
            BoardVo vo = new BoardVo(this);
//            vo.title = this.title;
//            vo.content = this.content;
            return vo;
        }
    }



}
