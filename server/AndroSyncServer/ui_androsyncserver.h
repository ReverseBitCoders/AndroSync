/********************************************************************************
** Form generated from reading UI file 'androsyncserver.ui'
**
** Created: Tue Mar 13 15:52:44 2012
**      by: Qt User Interface Compiler version 4.8.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ANDROSYNCSERVER_H
#define UI_ANDROSYNCSERVER_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QHBoxLayout>
#include <QtGui/QHeaderView>
#include <QtGui/QMainWindow>
#include <QtGui/QMenuBar>
#include <QtGui/QStatusBar>
#include <QtGui/QTabWidget>
#include <QtGui/QToolBar>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_AndroSyncServer
{
public:
    QWidget *centralWidget;
    QHBoxLayout *horizontalLayout;
    QTabWidget *tabWidget;
    QWidget *tab_contacts;
    QWidget *tab_sms;
    QWidget *tab_logs;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *AndroSyncServer)
    {
        if (AndroSyncServer->objectName().isEmpty())
            AndroSyncServer->setObjectName(QString::fromUtf8("AndroSyncServer"));
        AndroSyncServer->resize(652, 375);
        centralWidget = new QWidget(AndroSyncServer);
        centralWidget->setObjectName(QString::fromUtf8("centralWidget"));
        horizontalLayout = new QHBoxLayout(centralWidget);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        tabWidget = new QTabWidget(centralWidget);
        tabWidget->setObjectName(QString::fromUtf8("tabWidget"));
        tabWidget->setLayoutDirection(Qt::LeftToRight);
        tabWidget->setTabPosition(QTabWidget::West);
        tabWidget->setTabShape(QTabWidget::Rounded);
        tabWidget->setIconSize(QSize(32, 32));
        tab_contacts = new QWidget();
        tab_contacts->setObjectName(QString::fromUtf8("tab_contacts"));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/icons/icons/contacts.png"), QSize(), QIcon::Normal, QIcon::Off);
        tabWidget->addTab(tab_contacts, icon, QString());
        tab_sms = new QWidget();
        tab_sms->setObjectName(QString::fromUtf8("tab_sms"));
        QIcon icon1;
        icon1.addFile(QString::fromUtf8(":/icons/icons/message.png"), QSize(), QIcon::Normal, QIcon::Off);
        tabWidget->addTab(tab_sms, icon1, QString());
        tab_logs = new QWidget();
        tab_logs->setObjectName(QString::fromUtf8("tab_logs"));
        QIcon icon2;
        icon2.addFile(QString::fromUtf8(":/icons/icons/logs.png"), QSize(), QIcon::Normal, QIcon::Off);
        tabWidget->addTab(tab_logs, icon2, QString());

        horizontalLayout->addWidget(tabWidget);

        AndroSyncServer->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(AndroSyncServer);
        menuBar->setObjectName(QString::fromUtf8("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 652, 23));
        AndroSyncServer->setMenuBar(menuBar);
        mainToolBar = new QToolBar(AndroSyncServer);
        mainToolBar->setObjectName(QString::fromUtf8("mainToolBar"));
        AndroSyncServer->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(AndroSyncServer);
        statusBar->setObjectName(QString::fromUtf8("statusBar"));
        AndroSyncServer->setStatusBar(statusBar);

        retranslateUi(AndroSyncServer);

        tabWidget->setCurrentIndex(1);


        QMetaObject::connectSlotsByName(AndroSyncServer);
    } // setupUi

    void retranslateUi(QMainWindow *AndroSyncServer)
    {
        AndroSyncServer->setWindowTitle(QApplication::translate("AndroSyncServer", "AndroSyncServer", 0, QApplication::UnicodeUTF8));
        tabWidget->setTabText(tabWidget->indexOf(tab_contacts), QString());
        tabWidget->setTabText(tabWidget->indexOf(tab_sms), QString());
        tabWidget->setTabText(tabWidget->indexOf(tab_logs), QString());
    } // retranslateUi

};

namespace Ui {
    class AndroSyncServer: public Ui_AndroSyncServer {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ANDROSYNCSERVER_H
