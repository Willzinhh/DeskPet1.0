<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<fmt:setLocale value="pt_BR" />
<fmt:setTimeZone value="America/Sao_Paulo" />

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Agenda de Agendamentos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
  <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.css" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>
</head>
<body>
<div class="container my-4">
  <h1 class="mb-4">Agenda de Agendamentos</h1>

  <c:if test="${empty agendamentos}">
    <div class="alert alert-info">Nenhum agendamento encontrado.</div>
  </c:if>

  <c:if test="${not empty agendamentos}">
    <div id="calendar"></div>
  </c:if>

</div>

<script>
  // Formata valor numérico para moeda BRL
  function formatCurrency(value) {
    return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
  }

  var eventos = [
    <c:forEach var="agendamento" items="${agendamentos}" varStatus="status">
    {
      id: '${agendamento.id}',
      title: formatCurrency(${agendamento.valor != null ? agendamento.valor : 0}) + ' - ${agendamento.status}',
      start: '${agendamento.data_hora}',  // deve estar no formato ISO 8601: YYYY-MM-DDTHH:mm:ss
      color: '${agendamento.pagamento_efetuado ? "#198754" : "#ffc107"}'
    }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
  ];

  document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'timeGridDay',
      locale: 'pt-br',
      timeZone: 'America/Sao_Paulo',
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      events: eventos,
      eventTimeFormat: {
        hour: '2-digit',
        minute: '2-digit',
        hour12: false
      },
      eventDidMount: function(info) {
        info.el.setAttribute('title', info.event.title);
      }
    });
    calendar.render();
  });
</script>

</body>
</html>

