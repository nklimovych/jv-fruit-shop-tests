package core.basesyntax.model;

import java.util.Objects;

public class Transaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public Transaction(String operationCode, String fruitName, int quantity) {
        this.operation = Operation.getByCode(operationCode);
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transaction that)) {
            return false;
        }
        return quantity == that.quantity
                && operation == that.operation
                && Objects.equals(fruitName, that.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitName, quantity);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String operationCode) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(operationCode)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + operationCode);
        }
    }
}
