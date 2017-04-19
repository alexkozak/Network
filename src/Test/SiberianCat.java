package Test;

import javax.swing.*;

public class SiberianCat implements Cat {
    @Override
    public void mew() {
        System.out.println("MEW");
    }

    public static void main(String[] args) {
        SiberianCat cat = new SiberianCat();
        cat.mew();
    }
}
