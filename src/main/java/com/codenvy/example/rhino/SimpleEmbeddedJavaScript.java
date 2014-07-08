package com.codenvy.example.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class SimpleEmbeddedJavaScript {

    public void executeHelloRhino() {
        Context cx = Context.enter();

        try {
            Scriptable scope = cx.initStandardObjects();

            String script = "var s = 'Hello, Rhino'; s;";

            Object obj = cx.evaluateString(scope, script, "TestScript", 1, null);
            System.out.println("Script: " + script);
            System.out.println("Object: " + obj);
            System.out.println("Object class: " + obj.getClass() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Context.exit();
        }
    }

    public void executeAdd() {
        Context cx = Context.enter();

        try {
            Scriptable scope = cx.initStandardObjects();

            String script = "function addThree( a, b, c ) { return a + b + c } addThree( 5, 7, 9 );";

            Object obj = cx.evaluateString(scope, script, "TestScript", 1, null);
            System.out.println("Script: " + script);
            System.out.println("Object: " + obj);
            System.out.println("Object class: " + obj.getClass() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Context.exit();
        }
    }

    public Object execute(String script) {
        Context cx = Context.enter();

        try {
            Scriptable scope = cx.initStandardObjects();

            Object obj = cx.evaluateString(scope, script, "TestScript", 1, null);
            System.out.println("Script: " + script);
            System.out.println("Object: " + obj);
            System.out.println("Object class: " + obj.getClass() + "\n");

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Context.exit();
        }
        return -1;
    }

    public static void main(String[] args) {
        SimpleEmbeddedJavaScript simpleEmbeddedJavaScript = new SimpleEmbeddedJavaScript();

        simpleEmbeddedJavaScript.executeHelloRhino();
        simpleEmbeddedJavaScript.executeAdd();
        simpleEmbeddedJavaScript.execute("function factorial(x) { if (x == 0) { return 1; } return x * factorial(x - 1); } factorial(5);");
    }
}
