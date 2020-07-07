# xducoder

## spring boot, mybatis 后端服务器

包含DAO层基本的操作和部分功能接口（包含部分测试完成），提供http接口：

### notebookController：

|             接口（均为POST）              | 参数(REQUEST BODY,json格式) |
| :---------------------------------------: | :-------------------------: |
|    public boolean  /copyNbToUserBySrc     |       nbID,tarUserID        |
|     public boolean  /copyNbToUserByM      | UserID,path,name,tarUserId  |
|      public boolean  /deleteNbBynbID      |            nbId             |
| public List\<NoteBook\> /selectNbIDByUserID |           UserID            |
|   public boolean  /createUserDirectory    |         UserId,name         |
|   public boolean  /deleteUserDirectory    |           UserID            |
|   public boolean  /resetNoteBookByNbID    |            nbId             |

### JupyterLoginController：

|            接口            |  参数  |
| :------------------------: | :----: |
| public boolean  /isWorking |  null  |
| public String  /getSTDNum  | userID |
