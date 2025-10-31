package in.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "testServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        
        String env = System.getenv("ENVIRONMENT") != null ? System.getenv("ENVIRONMENT") : "Production";
        String server = req.getServerName() + ":" + req.getServerPort();

        out.println(String.format("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Hello from Servlet</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
                <style>
                    body {
                        font-family: 'Roboto', sans-serif;
                        background: linear-gradient(135deg, #6610f2, #6f42c1);
                        color: #fff;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        margin: 0;
                    }
                    .card {
                        background: rgba(255, 255, 255, 0.1);
                        border: none;
                        border-radius: 12px;
                        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
                        padding: 40px 30px;
                        text-align: center;
                        max-width: 500px;
                        backdrop-filter: blur(8px);
                    }
                    .card h1 {
                        font-weight: 700;
                        margin-bottom: 10px;
                    }
                    .card p {
                        font-size: 1.1rem;
                        opacity: 0.9;
                    }
                    a.btn {
                        margin-top: 20px;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <h1>🌤 Hello from Servlet!</h1>
                    <p>This page is served directly by <strong>TestServlet</strong>.</p>
                    <hr style='border-color: rgba(255,255,255,0.3);'>
                    <p><strong>Environment:</strong> %s</p>
                    <p><strong>Host:</strong> %s</p>
                    <p><strong>Time:</strong> %s</p>
                    <a href="/" class="btn btn-light btn-lg">Back to Home</a>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>
            </html>
            """, env, server, LocalDateTime.now()));
    }
}
