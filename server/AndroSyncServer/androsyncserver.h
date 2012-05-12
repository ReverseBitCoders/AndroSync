#ifndef ANDROSYNCSERVER_H
#define ANDROSYNCSERVER_H

#include <QMainWindow>
#include <QtSql>

namespace Ui {
    class AndroSyncServer;
}

class AndroSyncServer : public QMainWindow
{
    Q_OBJECT

public:
    explicit AndroSyncServer(QWidget *parent = 0);
    ~AndroSyncServer();

private slots:
    void on_pushBt_Contacts_clicked();

    void on_pushBt_dock_Home_clicked();

    void on_pushBt_dock_Messages_clicked();

    void on_pushBt_Messages_clicked();

    void on_pushBt_dock_Contacts_clicked();

    void on_pushBt_dock_Logs_clicked();

    void on_tabMessages_currentChanged(int index);

    void on_pushBt_Logs_clicked();

    void on_tabLogs_currentChanged(int index);

    void on_stackedPages_currentChanged(int arg1);

    void on_pushBt_Notes_clicked();

    void on_pushBt_dock_Notes_clicked();

private:
    Ui::AndroSyncServer *ui;
    QSqlTableModel *model;
    QSqlDatabase db;
};

#endif // ANDROSYNCSERVER_H
