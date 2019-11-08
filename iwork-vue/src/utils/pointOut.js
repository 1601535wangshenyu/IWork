export function success(msg){//成功提示
    this.$message({
      message:msg,
      type: 'success'
    });
}
export function error(msg){//错误提示
    this.$message({
      message:msg,
      type: 'error'
    });
}
export function warn(msg){//警告提示
    this.$message({
      message:msg,
      type: 'warning'
    });
}
