package four.connection;

public enum ConnectionProperties {
    URL("jdbc:mysql://localhost:3306/store"),
    USERNAME("root"),
    PASSWORD("root");

    private String value;

    ConnectionProperties(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
