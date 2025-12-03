package com.sofftekbackend.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiChatService {

    @Value("${ai.gemini.apikey}")
    private String geminiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String gerarResposta(String mensagemDoUsuario) {
        String geminiApiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + geminiApiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        String requestBody = """
            {
              "contents":[
                {
                  "parts":[
                    {
                      "text": "Você é um assistente virtual de bem-estar chamado SoftMind para evitar que pessoas sofram com burnout, ansiedade e depressão com base na NRA1 no dia-dia do trabalho. Responda de forma curta, calma e empática. O usuário disse: %s"
                    }
                  ]
                }
              ]
            }
            """.formatted(mensagemDoUsuario);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {

            String response = restTemplate.postForObject(geminiApiUrl, entity, String.class);


            return extrairTextoDaResposta(response);
        } catch (Exception e) {
            e.printStackTrace();
            return "Desculpe, não consegui processar sua mensagem no momento.";
        }
    }

    private String extrairTextoDaResposta(String jsonResponse) {

        int textIndex = jsonResponse.indexOf("\"text\": \"");
        if (textIndex == -1) return "Não entendi.";
        String start = jsonResponse.substring(textIndex + 9);
        int endIndex = start.indexOf("\"");
        return start.substring(0, endIndex).replace("\\n", "\n");
    }
}