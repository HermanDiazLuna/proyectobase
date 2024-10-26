package com.project.base.proyectobase.domain.model.exception;

import java.util.function.Supplier;

public class BusinessException extends ApplicationException{

    public enum Type {

        EMPLEADO_NO_EXISTE("Empleado no existe!");

        private final String message;

        Type(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public BusinessException create() {
            return new BusinessException(this);
        }

        public Supplier<BusinessException> asSupplier() {
            return () -> new BusinessException(this);
        }

    }

    private final Type type;

    public BusinessException(Type type){
        super(type.getMessage());
        this.type = type;
    }

}
