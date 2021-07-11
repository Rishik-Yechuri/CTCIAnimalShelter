import java.util.LinkedList;

public class CTCIAnimalShelter {
    public static void main(String[] args) {
        try{
            CTCIAnimalShelter obj = new CTCIAnimalShelter();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        MyShelter myShelter = new MyShelter();
        myShelter.enqueue("dog");
        myShelter.enqueue("cat");
        myShelter.enqueue("cat");
        myShelter.enqueue("dog");
        myShelter.enqueue("dog");
        myShelter.enqueue("dog");
        System.out.println(myShelter.dequeueAny());
        System.out.println(myShelter.dequeueDog());
        System.out.println(myShelter.dequeueAny());
    }
    class MyShelter{
        int idNum = 1;
        LinkedList<Integer> dogIDs = new LinkedList<Integer>();
        LinkedList<Integer> catIDs = new LinkedList<Integer>();
        public void enqueue(String animal){
            if(animal.equals("dog")){
                dogIDs.add(idNum);
            }else{
                catIDs.add(idNum);
            }
            idNum++;
        }
        public int dequeueAny(){
            if(dogIDs.isEmpty() && !catIDs.isEmpty() || !catIDs.isEmpty() && catIDs.peek() < dogIDs.peek()){
                return catIDs.poll();
            }else if(catIDs.isEmpty() && !dogIDs.isEmpty() || !dogIDs.isEmpty() && dogIDs.peek() <= catIDs.peek()){
                return dogIDs.poll();
            }
            return 0;
        }
        public int dequeueCat(){
            if(!catIDs.isEmpty()){
                return catIDs.poll();
            }
            return 0;
        }
        public int dequeueDog(){
            if(!dogIDs.isEmpty()){
                return dogIDs.poll();
            }
            return 0;
        }
    }
}