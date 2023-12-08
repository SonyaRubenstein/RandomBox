public class RandomBox<T> {
    private int key; //переменная интовая
    private T value; //переменная тоже

    public RandomBox(int key, T value) { //конструктор класса
        this.key = key;
        this.value = value;
    }

    public T tryUnlock(int key) { //метод "попробуй разблокировать"
        if (this.key == key) { //если ключ совпал
            return value; //верни значение
        } else {
            return null; //иначе верни null
        }
    }

    public int getKey() { //метод "дай ключ"
        return key;
    }

    public T getValue() { //метод "дай значение"
        return value;
    }
}