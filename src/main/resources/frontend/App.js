let currentMode = 'chat';

function setMode(mode) {

    currentMode = mode;
    // Обновляем стиль кнопок для визуального указания активного режима
    const buttons = document.querySelectorAll('.mode-button');
    buttons.forEach(button => {
        button.classList.remove('active');
        if (button.innerText.toLowerCase() === mode) {
            button.classList.add('active');
        }
    });
}

function sendMessage() {

    const inputField = document.getElementById('inputField');
    const output = document.getElementById('output');
    let message = inputField.value.trim();

    if (message) {
        alert("message")
        // Применяем текущий режим
        switch (currentMode) {
            case 'uppercase':
                message = message.toUpperCase();
                break;
            case 'lowercase':
                message = message.toLowerCase();
                break;
            // 'normal' - ничего не меняем
        }

        // Отправка сообщения на сервер
        fetch('/api/message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ text: message }) // отправка текста в формате JSON
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Сеть ответила с ошибкой');
                }
                return response.json();
            })
            .then(data => {
                // Выводим ответ от сервера, если это необходимо
                output.innerText += `Сервер ответил: ${data.response}\n`;
            })
            .catch(error => {
                console.error('Ошибка:', error);
                output.innerText += 'Ошибка при отправке сообщения.\n';
            });
        // Очищаем поле ввода
        inputField.value = '';
    } else {
        alert('Пожалуйста, введите сообщение!');
    }

    async function executeCommand() {
        const command = document.getElementById("command").value;
        const response = await fetch("http://localhost:8080/api/execute", {
            method: "POST",
            headers: {
                "Content-Type": "text/plain",
            },
            body: command,
        });
        const output = await response.json();
        document.getElementById("output").textContent = output.join("\n");
    }
}

