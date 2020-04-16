package com.sitarski.truckparkserver.exception;

public class TruckDriverWayNotFoundException extends RuntimeException {

        private static final long serialVersionUID = -470180507998010368L;

        public TruckDriverWayNotFoundException() {
            super();
        }

        public TruckDriverWayNotFoundException(final String message) {
            super(message);
        }
}
