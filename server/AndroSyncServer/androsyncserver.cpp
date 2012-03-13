#include "androsyncserver.h"
#include "ui_androsyncserver.h"

AndroSyncServer::AndroSyncServer(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::AndroSyncServer)
{
    ui->setupUi(this);
}

AndroSyncServer::~AndroSyncServer()
{
    delete ui;
}
