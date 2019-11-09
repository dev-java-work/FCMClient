package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

class FCMSender extends Sender {

    public FCMSender(String key) {
        super(key);
    }

    @Override
    protected HttpURLConnection getConnection(String url) throws IOException {
        String fcmUrl = "https://fcm.googleapis.com/fcm/send";
        return (HttpURLConnection) new URL(fcmUrl).openConnection();
    }
    
    
    public static void main(String[] args) {
       
        String serverKey = "";
    
                try {
                    Sender sender = new FCMSender(serverKey);
                    
                    Message message = new Message.Builder()
                                      .collapseKey("message")
                                      .timeToLive(3)
                                      .delayWhileIdle(true)
                                      .addData("message", "Notification from Java application")
                                      .build();  

                    // Use the same token(or registration id) that was earlier
                    // used to send the message to the client directly from
                    // Firebase Console's Notification tab.
                    Result result = sender.send(message,
                "APA91bFfIFjSCcSiJ111rbmkpnMkZY-Ej4RCpdBZFZN_mYgfHwFlx-M1UXS5FqDBcN8x1efrS2md8L9K_E9N21qB-PIHUqQwmF4p7Y3U-86nCGH7KNkZNjjz_P_qjcTR0TOrwXMh33vp",
                        1);
                    System.out.println("Result: " + result.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
           
          
            
          
        }
    
    
    }
    
