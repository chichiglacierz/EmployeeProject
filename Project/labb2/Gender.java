
package labb2;


public enum Gender {
    
    
    MALE {
        @Override
        public String toString(){
            return "Male";
        }
    },
    FEMALE {
        @Override
        public String toString(){
            return "Female";
        }
    },
    OTHER {
        @Override
        public String toString(){
            return "Gender fluid";
        }
    }
    
}
