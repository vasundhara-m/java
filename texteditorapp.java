
import java.util.Scanner;


interface StackADT<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}

class ArrayStack<T> implements StackADT<T> {
    private Object[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public void push(T item) {
        stack[++top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) return null;
        return (T) stack[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) return null;
        return (T) stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}


class TextEditor {
    private StringBuilder text = new StringBuilder();
    private StackADT<String> undoStack;

    public TextEditor(StackADT<String> stack) {
        this.undoStack = stack;
    }

    public void type(String word) {
        text.append(word);
        undoStack.push(word); // save operation
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            String lastWord = undoStack.pop();
            int len = lastWord.length();
            text.delete(text.length() - len, text.length());
        }
    }

    public void display() {
        System.out.println("Current Text: " + text.toString());
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor(new ArrayStack<>(100));

        while (true) {
            System.out.println("\n1. Type\n2. Undo\n3. Display\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String word = sc.nextLine();
                    editor.type(word);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
