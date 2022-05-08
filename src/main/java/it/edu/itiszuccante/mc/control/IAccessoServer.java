package it.edu.itiszuccante.mc.control;

public interface IAccessoServer {
    /**
     * Salva in un file il Server dato
     *
     * @param ip: IPv4 del Server
     * @param porta: porta del Server
     */
    public void saveServer(String ip, int porta);

    /**
     * Accede a nuovo Server, controllando che prima esista
     *
     * @param ip: IPv4 del Server
     * @param porta: porta del Server
     */
    public void startNew(String ip, int porta);

    /**
     * Accede a un Server salvato
     *
     * @param ip: IPv4 del Server
     * @param porta: porta del Server
     */
    public void startSaved(String ip, int porta);

    /**
     * Controlla se esiste un dato Server
     *
     * @param ip: IPv4 del Server
     * @param porta: porta del Server
     */
    public void checkServer(String ip, int porta);
}