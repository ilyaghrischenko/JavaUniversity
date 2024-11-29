public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int score = 0;
        int anotherScore = 0;

        if (this.age > anotherCat.age) score++;
        else if (this.age < anotherCat.age) anotherScore++;

        if (this.weight > anotherCat.weight) score++;
        else if (this.weight < anotherCat.weight) anotherScore++;

        if (this.strength > anotherCat.strength) score++;
        else if (this.strength < anotherCat.strength) anotherScore++;

        return score > anotherScore;
    }
}