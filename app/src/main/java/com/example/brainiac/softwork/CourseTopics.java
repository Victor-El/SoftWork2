package com.example.brainiac.softwork;

import java.util.ArrayList;
import java.util.Arrays;

public class CourseTopics {
    private ArrayList<String> mth101;
    private ArrayList<String> chm101;
    private ArrayList<String> eng103;
    private ArrayList<String> phy101;

    public CourseTopics() {
        String[] mth101Arr = {"Indices", "Logarithms", "Surds", "Sets", "Polynomials", "Inequalities",
                "Partial Fractions", "Solutions of Equations", "Permutation and combination", "Sequence and Series",
                "Binomial Theorem", "Priciples of Mathematical Induction", "Complex Numbers", "Binary Operations",
                "Calculator Tricks"};
        mth101 = new ArrayList<String>();
        for(String mthNames: mth101Arr) {
            mth101.add(mthNames);
        }

        String[] chm101Arr= {"Si units", "Chemical Reactions", "Mole Concepts", "Stoichiometry",
                "Molarity, Molality and Normality", "Empirical and Molecular Formular", "Atomic Structure",
                "Electronic Configuration of Atoms", "Crystalline Solids", "Chemical Equilibrium",
                "Thermodynamics", "RadioActivity", "Chemical Bonding", "Redux reactions", "ElectroChemistry",
                "Theory of Gases", "Kinetics of Chemical Reactions"};
        chm101 = new ArrayList<String>();
        for(String chmNames: chm101Arr) {
            chm101.add(chmNames);
        }

        String[] eng103Arr = {"Title Block", "Dimension and Convention", "Scale", "Geometric Constructions",
                "Tangency and bending of Arc", "Polygons", "Loci"};
        eng103 = new ArrayList<String>();
        for(String engNames: eng103Arr) {
            eng103.add(engNames);
        }

        String[] phy101Arr = {"Systems of Measurement", "Kinematics", "Scalars and Vectors",
                "Newton's Laws of Motion", "Work, Energy and Power", "Momentum and Collision",
                "Simple Harmonic Motion", "Equilibrium of Bodies"};
        phy101 = new ArrayList<String>();
        for(String phyNames: phy101Arr) {
            phy101.add(phyNames);
        }
    }

    public ArrayList<String> getMth101() {
        return mth101;
    }

    public ArrayList<String> getChm101() {
        return chm101;
    }
    public ArrayList<String> getPhy101() {
        return phy101;
    }
    public ArrayList<String> getEng103() {
        return eng103;
    }
}
