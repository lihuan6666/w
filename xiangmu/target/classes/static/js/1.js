// 获取模态框元素
var modal = document.getElementById("myModal");

// 获取打开模态框的按钮元素
var btn = document.getElementById("myBtn");

// 获取关闭按钮元素
var span = document.getElementsByClassName("close")[0];

// 点击按钮打开模态框
btn.onclick = function() {
    modal.style.display = "block";
}

// 点击 x 关闭模态框
span.onclick = function() {
    modal.style.display = "none";
}

// 在用户点击模态框外部时，关闭它
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// 提交统一的表单
$('#combinedForm').on('submit', function(e) {
    e.preventDefault(); // 阻止表单默认提交行为
    const roadName = $('#roadName').val();
    const roadLevel = $('#roadLevel').val();
    const density = $('#density').val();
    const length = $('#length').val();
    const connectedVillages = $('#connectedVillages').val();
    const road_start = $('#road_start').val();

    // 发送 AJAX 请求到后端 API 添加 shuju 数据
    $.ajax({
        url: '/api/add-shuju',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ roadName, roadLevel }),
        success: function(response) {
            console.log('shuju 数据添加成功:', response);
            // 添加 shuju2 数据
            addShuju2Data(density, length, connectedVillages, roadName, road_start);
        },
        error: function(error) {
            console.error('shuju 数据添加失败:', error);
            alert('shuju 数据添加失败！');
        }
    });
});

function addShuju2Data(density, length, connectedVillages, roadName, road_start) {
    // 发送 AJAX 请求到后端 API 添加 shuju2 数据
    $.ajax({
        url: '/api/add-shuju2',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ density, length, connectedVillages, roadName, road_start }),
        success: function(response) {
            console.log('shuju2 数据添加成功:', response);
            alert('所有数据添加成功！');
            modal.style.display = "none"; // 关闭模态框
        },
        error: function(error) {
            console.error('shuju2 数据添加失败:', error);
            alert('shuju2 数据添加失败！');
        }
    });
}
document.getElementById('importBtn').addEventListener('click', function() {
    const fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.accept = '.xlsx';
    fileInput.onchange = function(e) {
        const file = e.target.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('file', file);
            fetch('/api/import', {
                method: 'POST',
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                    alert('数据导入成功');
                    location.reload();
                })
                .catch((error) => {
                    console.error('Error:', error);
                    alert('数据导入失败');
                });
        }
    };
    fileInput.click();
});