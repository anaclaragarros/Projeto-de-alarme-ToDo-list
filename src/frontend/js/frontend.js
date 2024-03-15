var tasks = [];

function saveTask() {
    var taskName = document.getElementById('taskName').value;
    var taskDescription = document.getElementById('taskDescription').value;
    var taskPriority = document.getElementById('taskPriority').value;
    var taskCategory = document.getElementById('taskCategory').value;
    var taskStatus = document.getElementById('taskStatus').value;

    var existingTask = tasks.find(task => task.name === taskName);

    if (existingTask) {
        existingTask.description = taskDescription;
        existingTask.priority = taskPriority;
        existingTask.category = taskCategory;
        existingTask.status = taskStatus;
    } else {
        var newTask = {
            name: taskName,
            description: taskDescription,
            priority: taskPriority,
            category: taskCategory,
            status: taskStatus
        };
        tasks.push(newTask);
    }

    document.getElementById('taskForm').reset();
    displayTasks();
}

function deleteTask(taskName) {
    tasks = tasks.filter(task => task.name !== taskName);
    displayTasks();
}

function editTask(taskName) {
    var taskToEdit = tasks.find(task => task.name === taskName);

    document.getElementById('taskName').value = taskToEdit.name;
    document.getElementById('taskDescription').value = taskToEdit.description;
    document.getElementById('taskPriority').value = taskToEdit.priority;
    document.getElementById('taskCategory').value = taskToEdit.category;
    document.getElementById('taskStatus').value = taskToEdit.status;

    deleteTask(taskName);
}

function displayTasks(filteredTasks) {
    var taskListElement = document.getElementById('taskList');
    taskListElement.innerHTML = '';

    (filteredTasks || tasks).forEach(task => {
        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${task.name}</td>
            <td>${task.description}</td>
            <td>${task.priority}</td>
            <td>${task.category}</td>
            <td>${task.status}</td>
            <td>
                <span class="edit-btn" onclick="editTask('${task.name}')">Editar</span>
                <span class="delete-btn" onclick="deleteTask('${task.name}')">Excluir</span>
            </td>
        `;
        taskListElement.appendChild(row);
    });
}

function filterTasks() {
    var filterStatus = document.getElementById('filterStatus').value;
    var filterPriority = document.getElementById('filterPriority').value;
    var filterCategory = document.getElementById('filterCategory').value.toLowerCase();

    var filteredTasks = tasks.filter(task => {
        return (filterStatus === 'ALL' || task.status === filterStatus) &&
            (filterPriority === 'ALL' || task.priority === filterPriority) &&
            (task.category.toLowerCase().includes(filterCategory));
    });

    displayTasks(filteredTasks);
}

displayTasks();