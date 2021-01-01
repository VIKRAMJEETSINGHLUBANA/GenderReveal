package Gender.code;

public class GenderResource
{
//    initializing the variables;
    private final String animal;
    private String male;
    private String female;
    int indexOfAnimal;
    private String malePic;
    private String femalePic;

//    making froup of male female so that we can get gender according to the index
//    of animal group
    public String[] animalGroup = {
            "ass","bear","cat","cattle","chicken","deer","dog","duck","elephant",
            "fox","goose","horse","human","lion","rabbit","sheep","swan","swine","tiger",
            "whale","wolf"
    };
    private String[] maleGroup = {
            "jack","boar","tom","bull","rooster","buck","dog","drake","bull",
            "dog","gander","stallion","boy/man","lion","buck","ram","cob","boar","tiger",
            "bull","dog"
    };
    private String[] femaleGroup = {
            "jenny","sow","queen","cow","hen","doe","bitch","duck","cow",
            "vixen","goose","mare","girl/woman","lioness","doe","ewe","pen","sow","tigress",
            "cow","bitch"
    };
//constructor set animal for which information to retrieve
    GenderResource(String animal){
        this.animal = animal;

        for (int i = 0; i < animalGroup.length;i++){
            if (animalGroup[i].equals(this.animal)) {
                indexOfAnimal = i;
                break;
            }
        }
//        System.out.println(indexOfAnimal);
        setMale(indexOfAnimal);
        setFemale();
        setFemalePic(this.animal);
        setMalePic(this.animal);
    }

    private void setMale(int indexOfAnimal){
        male = maleGroup[indexOfAnimal];
    }
    private void setFemale(){
        female = femaleGroup[indexOfAnimal];
    }
    // sets male and female pics with M.jpg/F.jpg extension respectively
    private void setMalePic(String malePic) {
        this.malePic = malePic.concat("M.jpg");
    }

    private void setFemalePic(String femalePic) {
        this.femalePic = femalePic.concat("F.jpg");
    }
// returns male and female NOUN's
    public String getMale(){
        return this.male;
    }
    public String getFemale(){
        return this.female;
    }

    //    return male/female pics
    public String getMalePic() {
        return malePic;
    }

    public String getFemalePic() {
        return femalePic;
    }

}
