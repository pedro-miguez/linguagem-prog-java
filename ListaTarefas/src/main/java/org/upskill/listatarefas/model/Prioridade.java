package org.upskill.listatarefas.model;

public enum Prioridade {
    BAIXA {
        public String toString() {
            return "Baixa";
        }
    },
    ABAIXO_NORMAL {
        public String toString() {
            return "Abaixo do Normal";
        }
    },
    NORMAL {
        public String toString() {
            return "Normal";
        }
    },
    ACIMA_NORMAL {
        public String toString() {
            return "Acima do Normal";
        }
    },
    ELEVADO {
        public String toString() {
            return "Elevado";
        }
    },
    TEMPO_REAL {
        public String toString() {
            return "Tempo Real";
        }
    };
}


