<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to My WebApp</title>

    <!-- Mobile responsiveness -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #007bff, #6610f2);
            color: #fff;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0;
        }
        .card {
            background: rgba(255, 255, 255, 0.1);
            border: none;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            padding: 40px 30px;
            text-align: center;
            max-width: 450px;
            backdrop-filter: blur(8px);
        }
        .card h1 {
            font-weight: 700;
            margin-bottom: 15px;
        }
        .card p {
            font-size: 1.1rem;
            opacity: 0.9;
        }
        footer {
            position: absolute;
            bottom: 10px;
            font-size: 0.85rem;
            opacity: 0.8;
        }
    </style>
</head>
<body>
<div class="card">
    <h1>🚀 Welcome to My WebApp</h1>
    <p>Your Java web application is successfully deployed on the cloud!</p>
    <hr style="border-color: rgba(255,255,255,0.3);">
    <p>
        <strong>Environment:</strong>
        <%= System.getenv("ENVIRONMENT") != null ? System.getenv("ENVIRONMENT") : "Production" %>
    </p>
    <p>
        <strong>Host:</strong>
        <%= request.getServerName() + ":" + request.getServerPort() %>
    </p>
</div>

<footer>
    &copy; <%= java.time.Year.now() %> My Cloud WebApp. All rights reserved.
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
