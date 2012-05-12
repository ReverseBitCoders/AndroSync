#include <QtSql>
//#include <QtDebug>
#include "androsyncserver.h"
#include "ui_androsyncserver.h"

AndroSyncServer::AndroSyncServer(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::AndroSyncServer)
{
    ui->setupUi(this);
    //this->setStyleSheet("background-color: rgb(0,0,0);");
    //ui->pushBt_dock_Messages->setStyleSheet("QPushButton{background-color:gray}");
    ui->dockSideBar->hide();

    ui->pushButton_Edit->hide();
    ui->pushButton_Delete->hide();


    QSqlDatabase db = QSqlDatabase::addDatabase("QMYSQL");
    db.setDatabaseName("AndroSync");
    db.setUserName("androsync");
    db.setPassword("androsync");

    bool ok = db.open();
     if (ok){
         qDebug("Opened DB connenction");

     } else {
         qDebug() << "Error: " << db.lastError().text();
         exit(1);
     }
}

AndroSyncServer::~AndroSyncServer()
{
    db.close();
    delete ui;
}

void AndroSyncServer::on_pushBt_Contacts_clicked()
{
    ui->dockSideBar->show();
    ui->lblTitle->setText("<h2>Contacts</h2>");
    ui->stackedPages->setCurrentIndex(1);
//    ui->listContacts->clear();
    model = new QSqlTableModel();
    model->setTable("contactsTbl");
    model->select();

    ui->tableViewContacts->setModel(model);
    ui->tableViewContacts->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
    ui->tableViewContacts->hideColumn(0);
//         // execute query
//         QSqlQuery query;
//         query.exec("SELECT * FROM contactsTbl");
//         // iterate over the result
//         while (query.next()) {
//             int id = query.value(0).toInt();
//             QString name = query.value(1).toString();
//             QString number = query.value(2).toString();
//             //qDebug() << id << name << number;
//             ui->listContacts->addItem(name + " " + number);

//         }
//         query.lastError().text();


/*----------------------------------------------------*/
}

void AndroSyncServer::on_pushBt_dock_Home_clicked()
{
    ui->stackedPages->setCurrentIndex(0);
    ui->lblTitle->setText("<h2>AndroSync</h2>");
    ui->dockSideBar->hide();
    ui->pushButton_Edit->hide();
    ui->pushButton_Delete->hide();
}

void AndroSyncServer::on_pushBt_dock_Messages_clicked()
{
    ui->stackedPages->setCurrentIndex(2);
    ui->lblTitle->setText("<h2>Messages</h2>");
    ui->tabMessages->setCurrentIndex(0);

    model = new QSqlTableModel();
    model->setTable("sms_inbox");
    model->select();

    ui->tableViewInbox->setModel(model);
    ui->tableViewInbox->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
    ui->tableViewInbox->hideColumn(0);

}

void AndroSyncServer::on_pushBt_Messages_clicked()
{
    ui->stackedPages->setCurrentIndex(2);
    ui->lblTitle->setText("<h2>Messages</h2>");
    ui->dockSideBar->show();
    ui->tabMessages->setCurrentIndex(0);

    model = new QSqlTableModel();
    model->setTable("sms_inbox");
    model->select();

    ui->tableViewInbox->setModel(model);
    ui->tableViewInbox->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
    ui->tableViewInbox->hideColumn(0);
}

void AndroSyncServer::on_pushBt_dock_Contacts_clicked()
{
    ui->stackedPages->setCurrentIndex(1);
    ui->lblTitle->setText("<h2>Contacts</h2>");
}

void AndroSyncServer::on_pushBt_dock_Logs_clicked()
{
    ui->stackedPages->setCurrentIndex(3);
    ui->lblTitle->setText("<h2>Logs</h2>");
    ui->dockSideBar->show();
    ui->tabLogs->setCurrentIndex(0);

    model = new QSqlTableModel();
    model->setTable("call_incoming");
    model->select();

    ui->tableViewIncoming->setModel(model);
    ui->tableViewIncoming->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
}

void AndroSyncServer::on_tabMessages_currentChanged(int index)
{
    if( 0 == index) {
        model = new QSqlTableModel();
        model->setTable("sms_inbox");
        model->select();

        ui->tableViewInbox->setModel(model);
        ui->tableViewInbox->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
        ui->tableViewInbox->hideColumn(0);

    } else if ( 1 == index) {
        model = new QSqlTableModel();
        model->setTable("sms_outbox");
        model->select();

        ui->tableViewOutbox->setModel(model);
        ui->tableViewOutbox->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
        ui->tableViewOutbox->hideColumn(0);

    } else {
        model = new QSqlTableModel();
        model->setTable("sms_drafts");
        model->select();

        ui->tableViewDrafts->setModel(model);
        ui->tableViewDrafts->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
        ui->tableViewDrafts->hideColumn(0);
    }
}

void AndroSyncServer::on_pushBt_Logs_clicked()
{
    ui->stackedPages->setCurrentIndex(3);
    ui->lblTitle->setText("<h2>Logs</h2>");
    ui->dockSideBar->show();
    ui->tabLogs->setCurrentIndex(0);

    model = new QSqlTableModel();
    model->setTable("call_incoming");
    model->select();

    ui->tableViewIncoming->setModel(model);
    ui->tableViewIncoming->horizontalHeader()->setResizeMode(QHeaderView::Stretch);

}

void AndroSyncServer::on_tabLogs_currentChanged(int index)
{
    if( 0 == index) {
        model = new QSqlTableModel();
        model->setTable("call_incoming");
        model->select();

        ui->tableViewIncoming->setModel(model);
        ui->tableViewIncoming->horizontalHeader()->setResizeMode(QHeaderView::Stretch);

    } else if ( 1 == index) {
        model = new QSqlTableModel();
        model->setTable("call_outgoing");
        model->select();

        ui->tableViewOutgoing->setModel(model);
        ui->tableViewOutgoing->horizontalHeader()->setResizeMode(QHeaderView::Stretch);

    } else {
        model = new QSqlTableModel();
        model->setTable("call_missed");
        model->select();

        ui->tableViewMissed->setModel(model);
        ui->tableViewMissed->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
    }
}

void AndroSyncServer::on_stackedPages_currentChanged(int arg1)
{
    if(ui->stackedPages->currentIndex() == 0) {
        ui->pushButton_Delete->hide();
        ui->pushButton_Edit->hide();
    } else {
        ui->pushButton_Delete->show();
        ui->pushButton_Edit->show();
    }
}

void AndroSyncServer::on_pushBt_Notes_clicked()
{
    ui->stackedPages->setCurrentIndex(4);
    ui->lblTitle->setText("<h2>Calender</h2>");
    ui->dockSideBar->show();

    model = new QSqlTableModel();
    model->setTable("calender");
    model->select();

    ui->tableViewCalender->setModel(model);
    ui->tableViewCalender->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
}

void AndroSyncServer::on_pushBt_dock_Notes_clicked()
{
    ui->stackedPages->setCurrentIndex(4);
    ui->lblTitle->setText("<h2>Calender</h2>");

    model = new QSqlTableModel();
    model->setTable("calender");
    model->select();

    ui->tableViewCalender->setModel(model);
    ui->tableViewCalender->horizontalHeader()->setResizeMode(QHeaderView::Stretch);
}
