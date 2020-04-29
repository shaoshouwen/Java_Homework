


public class Students {
    private String name;
    public Students(String name) {
        setName(name);

    }


        public void study(){
            System.out.println(getName()+"认真学习");
        }
        private String getName(){
            return name;
        }

        private void setName(String name){
            this.name = name;
        }

}
