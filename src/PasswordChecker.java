public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 1) {
            throw new IllegalArgumentException("Минимальная длина не может быть меньше 1 символа");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <0) {
            throw new IllegalArgumentException("Максимальное число повторений должно быть больше 0");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (password.length() < minLength) {
            return false;
        }

        int count = 0;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                count++;
            } else {
                count = 0;
            }
            if (count > maxRepeats) {
                return false;
            }
        }
        return true;
    }
}
