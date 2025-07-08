package com.example.karta_agona;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.LongPressAwareTableDataAdapter;

public class TeamTableDataAdapterR8 extends LongPressAwareTableDataAdapter<TeamR8> {


    public TeamTableDataAdapterR8(final Context context, final List<TeamR8> data, final TableView<TeamR8> tableView) {
        super(context, data, tableView);
    }

    @Override
    public View getDefaultCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        TeamR8 team = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderName(team);
                break;
            case 1:
                renderedView = renderGP(team);
                break;
            case 2:
                renderedView = renderP(team);
                break;
            case 3:
                renderedView = renderPPG(team);
                break;
            case 4:
                renderedView = renderMade2P(team);
                break;
            case 5:
                renderedView = renderMade3P(team);
                break;
            case 6:
                renderedView = renderMadeFT(team);
                break;
            case 7:
                renderedView = renderREBS(team);
                break;
            case 8:
                renderedView = renderDEF_REBS(team);
                break;
            case 9:
                renderedView = renderOFF_REBS(team);
                break;
            case 10:
                renderedView = renderAST(team);
                break;
            case 11:
                renderedView = renderBLK(team);
                break;
            case 12:
                renderedView = renderBLKON(team);
                break;
            case 13:
                renderedView = renderSTL(team);
                break;
            case 14:
                renderedView = renderTO(team);
                break;
            case 15:
                renderedView = renderFOULSF(team);
                break;
            case 16:
                renderedView = renderFOULSM(team);
                break;
//            case 17:
//                renderedView = renderRANK(team);
//                break;
        }
        return renderedView;
    }

    @Override
    public View getLongPressCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        return null;
    }

    private View renderName(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(team.getName());
        textView.setPadding(10, 10, 0, 10);
        textView.setSingleLine(false);
        return textView;
    }

    private View renderGP(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getGames_played()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderP(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getPoints()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderPPG(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.format("%.2f", (double) team.getPoints() / (double) team.getGames_played()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderMade2P(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(team.getMade2p()+"-"+team.getAttempted2p());
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderMade3P(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(team.getMade3p()+"-"+team.getAttempted3p());
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderMadeFT(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(team.getMadeft()+"-"+team.getAttemptedft());
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderREBS(TeamR8 team){
        final TextView textView = new TextView(getContext());
        int rebs= team.getOff_rebs()+team.getDef_rebs();
        textView.setText(String.valueOf(rebs));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderDEF_REBS(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getDef_rebs()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderOFF_REBS(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getOff_rebs()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderAST(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getAssist()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderBLK(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getBlocks()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderBLKON(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getBlocks_on()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderSTL(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getSteals()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderTO(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getTurnovers()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderFOULSF(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getFouls_drawn()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private View renderFOULSM(TeamR8 team){
        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(team.getFouls_commited()));
        textView.setPadding(30, 0, 0, 0);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

//    private View renderRANK(TeamR8 team){
//        final TextView textView = new TextView(getContext());
//        textView.setText(String.valueOf(team.getRank()));
//        textView.setGravity(Gravity.CENTER);
//        return textView;
//    }
}
