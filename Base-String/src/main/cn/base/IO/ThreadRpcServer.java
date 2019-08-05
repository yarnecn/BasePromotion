package cn.base.IO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-07-30 16:30
 **/
public class ThreadRpcServer {
    public static void main(String args[]) {

        Socket clientSocket = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8081);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                clientSocket = ss.accept();
            }
            catch (IOException e) {
                continue;
            }

            new ServerThread(clientSocket).start();
        }
    }
}

class ServerThread extends Thread {
    private Socket clientSocket;
    public ServerThread(Socket s) {
        this.clientSocket = s;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            String serviceName = ois.readUTF();
            String methodName = ois.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
            Object[] parameters = (Object[]) ois.readObject();

            Class<?> service = Class.forName(serviceName);
            Method method = service.getMethod(methodName, parameterTypes);
            oos.writeObject(method.invoke(service.newInstance(), parameters));
        } catch(Exception e) {
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}