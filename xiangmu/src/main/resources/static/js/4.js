// 2.js
document.addEventListener('DOMContentLoaded', function() {
    // 获取模态框元素
    var modal = document.getElementById("myModal");
    // 获取打开模态框的按钮元素
    var btn = document.getElementById("openModalBtn");
    // 获取关闭模态框的 <span> 元素
    var span = document.getElementsByClassName("close")[0];

    // 点击按钮打开模态框
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // 点击 <span> (x), 关闭模态框
    span.onclick = function() {
        modal.style.display = "none";
    }

    // 在用户点击模态框外部时，关闭它
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    document.getElementById('openModalBtn').addEventListener('click', function() {
        document.getElementById('myModal').style.display = 'block';
    });
    // 表单提交事件处理
    document.getElementById('addConstructForm').addEventListener('submit', function(event) {
        event.preventDefault(); // 阻止表单默认提交行为

        document.querySelector('.close').addEventListener('click', function() {
            document.getElementById('myModal').style.display = 'none';
        });
    });
});