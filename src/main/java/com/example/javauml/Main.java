package com.example.javauml;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing JavaUML Objects...");

        CgComment comment = new CgComment();
        comment.key = 1;
        comment.comment = "This is a comment";
        System.out.println(comment);

        Typedef typedef = new Typedef();
        typedef.name = "MyType";
        typedef.key = 2;
        System.out.println(typedef);

        Conference conference = new Conference();
        conference.name = "JavaOne";
        System.out.println(conference);

        Isa isa = new Isa();
        isa.parent = "Parent";
        isa.child = "Child";
        System.out.println(isa);

        Cgc cgc = new Cgc();
        cgc.name = "Component";
        cgc.fs = new String[] { "Feature1", "Feature2" };
        System.out.println(cgc);

        Cgr cgr = new Cgr();
        cgr.name = "Relation";
        cgr.fromId = 1;
        cgr.toId = 2;
        System.out.println(cgr);

        Cg cg = new Cg();
        cg.key = 100;
        cg.fs = new String[] { "GraphFeature" };
        System.out.println(cg);

        IsaKind isaKind = new IsaKind();
        isaKind.isaObject = "KindObject";
        isaKind.characteristics = new String[] { "Char1" };
        isaKind.subtypes = new String[] { "Sub1" };
        System.out.println(isaKind);

        System.out.println("JavaUML Objects Initialized Successfully.");
    }
}
