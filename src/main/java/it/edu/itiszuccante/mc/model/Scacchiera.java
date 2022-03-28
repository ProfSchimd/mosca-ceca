package it.edu.itiszuccante.mc.model;

import java.util.Random;

import it.edu.itiszuccante.mc.control.IAgente;

public class Scacchiera implements IScacchiera {

    public static final int LATO_SCACCHIERA = 100;

    private ICasella scac[][];
    private int lenx;
    private int leny;

    public Scacchiera() {
        lenx = LATO_SCACCHIERA;
        leny = LATO_SCACCHIERA;
        generate();
    }

    @Override
    public void generate() {
        scac = new Casella[lenx][leny];
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                Random r = new Random();
                int rand = r.nextInt(100);
                if (rand < 40)
                    rand = 0;
                else if (rand < 90)
                    rand = 1;
                else
                    rand = 2;
                switch (rand) {
                    case 0:
                        scac[i][j] = new Casella();
                        break;
                    case 1:
                        // scac[i][j] = new Seta((int) (Math.random()*9)+1, new ConcreteCasella());
                        scac[i][j] = new CasellaRisorsa(new Seta());
                        break;
                    case 2:
                        // scac[i][j] = new Energia(new ConcreteCasella(), i, j);
                        scac[i][j] = new CasellaRisorsa(new Energia());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void posAg(IAgente agente) {
        boolean b = true;
        while (b) {
            Random r = new Random();
            int x = r.nextInt(LATO_SCACCHIERA);
            int y = r.nextInt(LATO_SCACCHIERA);
            // TODO: Questo non funziona: una casella può essere contemporaneamente occupata
            // e risorse. Probabilmente le caselle occupate vanno indicate in modo diverso
            if (!(getCasella(x, y) instanceof CasellaOccupata)) {
                scac[x][y] = new CasellaOccupata(agente);
                b = false;
            }
        }
    }

    @Override
    public ICasella[] getNeighborhood(int x, int y) {
        ICasella tmp[];
        if ((x == 0) && (y == 0)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x, y + 1);
            tmp[1] = getCasella(x + 1, y + 1);
            tmp[2] = getCasella(x + 1, y);
        } else if ((x == lenx) && (y == leny)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x, y - 1);
            tmp[2] = getCasella(x - 1, y - 1);
        } else if ((x == 0) && (y == leny)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x + 1, y);
            tmp[1] = getCasella(x + 1, y - 1);
            tmp[2] = getCasella(x, y - 1);
        } else if ((x == lenx) && (y == 0)) {
            tmp = new Casella[3];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
        } else if (y == 0) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x + 1, y + 1);
            tmp[4] = getCasella(x + 1, y);
        } else if (x == 0) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x, y + 1);
            tmp[1] = getCasella(x + 1, y + 1);
            tmp[2] = getCasella(x + 1, y);
            tmp[3] = getCasella(x + 1, y - 1);
            tmp[4] = getCasella(x, y - 1);
        } else if (y == leny) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x + 1, y);
            tmp[2] = getCasella(x + 1, y - 1);
            tmp[3] = getCasella(x, y - 1);
            tmp[4] = getCasella(x - 1, y - 1);
        } else if (x == lenx) {
            tmp = new Casella[5];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x, y - 1);
            tmp[4] = getCasella(x - 1, y - 1);
        } else {
            tmp = new Casella[8];
            tmp[0] = getCasella(x - 1, y);
            tmp[1] = getCasella(x - 1, y + 1);
            tmp[2] = getCasella(x, y + 1);
            tmp[3] = getCasella(x + 1, y + 1);
            tmp[4] = getCasella(x + 1, y);
            tmp[5] = getCasella(x + 1, y - 1);
            tmp[6] = getCasella(x, y - 1);
            tmp[7] = getCasella(x - 1, y - 1);
        }
        return tmp;
    }

    @Override
    public boolean pianta(int x, int y, IAgente agg) {
        // TODO: bisogna aggiungere le condizioni che se la casella non è vuota non può
        // piantare
        scac[x][y] = new CasellaBandiera(agg);
        return false;
    }

    @Override
    public String getStato(int x, int y) {
        // TODO Serve?
        return null;
    }

    @Override
    public ICasella getCasella(int x, int y) {
        return scac[x][y];
    }

    @Override
    public int getLenx() {
        return lenx;
    }

    @Override
    public void setLenx(int lenx) {
        this.lenx = lenx;
    }

    public int getLeny() {
        return leny;
    }

    public void setLeny(int leny) {
        this.leny = leny;
    }

    @Override
    public String toString() {
        String tab = "";
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                // TODO: Substitute equals with isinstanceof
                if (scac[i][j].toString().equals("vuota"))
                    tab += "|x|";
                else if (scac[i][j].toString().contains("Seta"))
                    tab += "|S|";
                else if (scac[i][j].toString().contains("Energia"))
                    tab += "|E|";
                else
                    tab += "|O|";
            }
            tab += " \n";
        }
        return tab;
    }

}
